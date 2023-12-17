const socket = io();

// video
const myFace = document.getElementById("myFace");
const muteBtn = document.getElementById("mute");
const cameraBtn = document.getElementById("camera");
const camerasSelect = document.getElementById("cameras");

const welcome = document.getElementById("welcome");
const call = document.getElementById("call");

let myStream; //video와 audio가 합쳐진 데이터
//음소거, 카메라 꺼짐 상태 저장.
let muted = false;
let cameraOff = false;
//방 정보 저장
let roomName;
//RTC 커넥션 저장
let myPeerConnection;
//DataChanel 저장
let myDataChannel;

async function getCameras() {
  try {
    const devices = await navigator.mediaDevices.enumerateDevices();
    const cameras = devices.filter((device) => device.kind === "videoinput");
    const currentCamera = myStream.getVideoTracks()[0];
    cameras.forEach((camera) => {
      const option = document.createElement("option");
      option.value = camera.deviceId;
      option.innerText = camera.label;
      if (currentCamera.label === camera.label) {
        option.selected = true;
      }
      camerasSelect.appendChild(option);
    });
  } catch (error) {
    console.log(error);
  }
}

//user의 미디어 데이터를 String으로 반환
async function getMedia(deviceId) {
  const initialConstraing = {
    audio: true,
    video: { facingMode: "user" },
  };
  const cameraConstraints = {
    audio: true,
    video: { deviceId: { exact: deviceId } },
  };
  try {
    myStream = await navigator.mediaDevices.getUserMedia(
      deviceId ? cameraConstraints : initialConstraing
    );
    myFace.srcObject = myStream;
    if (!deviceId) {
      await getCameras();
    }
  } catch (error) {
    console.log(error);
  }
}

//음소거, 카메라 끄고 켜기 기능
function handleMuteClick() {
  myStream
    .getAudioTracks()
    .forEach((track) => (track.enabled = !track.enabled));
  if (!muted) {
    muteBtn.innerText = "Unmute";
    muted = true;
  } else {
    muteBtn.innerText = "Mute";
    muted = false;
  }
}
function handleCameraClick() {
  myStream
    .getVideoTracks()
    .forEach((track) => (track.enabled = !track.enabled));
  if (!cameraOff) {
    cameraBtn.innerText = "Turn Camera On";
    cameraOff = true;
  } else {
    cameraBtn.innerText = "Turn Camera Off";
    cameraOff = false;
  }
}

async function handleCameraChange() {
  await getMedia(camerasSelect.value);
  if (myPeerConnection) {
    const videoTrack = myStream.getVideoTracks()[0]; // 새로 생긴 스트림에서 비디오 트랙을 받아옴.
    const videoSender = myPeerConnection
      .getSenders()
      .find((sender) => sender.track.kind === "video");
    videoSender.replaceTrack(videoTrack); // 비디오 트랙 교체
  }
}

muteBtn.addEventListener("click", handleMuteClick);
cameraBtn.addEventListener("click", handleCameraClick);
camerasSelect.addEventListener("input", handleCameraChange);

/// Welcom Form (Join a room)

const welcomeForm = welcome.querySelector("form");

async function initCall() {
  welcome.hidden = true;
  call.hidden = false;
  await getMedia();
  makeConnection();
}

async function handleWelcomeSubmit(event) {
  event.preventDefault();
  const input = welcomeForm.querySelector("input");
  await initCall();
  socket.emit("join_room", input.value);
  roomName = input.value;
  input.value = "";
}

welcomeForm.addEventListener("submit", handleWelcomeSubmit);

// Socket Code

//Peer A에서 일어나는 일 offer를 만들어 서버로 보냄
socket.on("welcome", async () => {
  myDataChannel = myPeerConnection.createDataChannel("chat");
  myDataChannel.addEventListener("message", (event) => {
    console.log(event.data);
  });
  console.log("DataChannel 생성됨.");
  const offer = await myPeerConnection.createOffer();
  myPeerConnection.setLocalDescription(offer);
  //서버로 offer에 대한 내용과 우리가 접속한 방이름을 보낸다.
  console.log("offer를 보냄!");
  socket.emit("offer", offer, roomName);
});

//Peer B에서 일어나는 일 서버에서 offer가 날라오면 setting함함.
socket.on("offer", async (offer) => {
  myPeerConnection.addEventListener("datachannel", (event) => {
    myDataChannel = event.channel;
    myDataChannel.addEventListener("message", (event) => {
      console.log(event.data);
    });
  });
  console.log("offer를 받음!");
  myPeerConnection.setRemoteDescription(offer);
  const answer = await myPeerConnection.createAnswer();
  myPeerConnection.setLocalDescription(answer);
  socket.emit("answer", answer, roomName);
  console.log("answer를 보냄!");
});

//Peer A에서 일어나는 일 서버에서 offer가 날라오면 setting함.
socket.on("answer", async (answer) => {
  console.log("answer를 받음!");
  myPeerConnection.setRemoteDescription(answer);
});

//Peer A에서 일어나는 일 서버에서 offer가 날라오면 setting함.
socket.on("ice", async (ice) => {
  console.log("ice를 저장!");
  myPeerConnection.addIceCandidate(ice);
});

// RTC Code

function makeConnection() {
  //각 브라우저의 영상, 오디오를 커넥션에 담아 준비
  myPeerConnection = new RTCPeerConnection({
    //STUN 서버로 구글의 서비스를 사용 - 테스트용 서버
    iceServers: [
      {
        urls: [
          "stun:stun.l.google.com:19302",
          "stun:stun1.l.google.com:19302",
          "stun:stun2.l.google.com:19302",
          "stun:stun3.l.google.com:19302",
          "stun:stun4.l.google.com:19302",
        ],
      },
    ],
  });
  //IceCandidate
  myPeerConnection.addEventListener("icecandidate", handleIce);
  myPeerConnection.addEventListener("track", handleTrack);
  myStream
    .getTracks()
    .forEach((track) => myPeerConnection.addTrack(track, myStream));
}

function handleIce(data) {
  console.log("ice를 보냄!");
  socket.emit("ice", data.candidate, roomName);
}

function handleTrack(data) {
  console.log(data);
  const peerFace = document.getElementById("peerFace");
  peerFace.srcObject = data.streams[0];
}
