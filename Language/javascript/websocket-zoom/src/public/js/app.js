const messageList = document.querySelector("ul");
const nickForm = document.querySelector("#nick");
const messageForm = document.querySelector("#message");
const socket = new WebSocket(`ws://${window.location.host}`); //클라이언트에서 웹소켓을 서버로 연결하는 코드.

function makeMessage(type, payload) {
  const msg = { type, payload };
  return JSON.stringify(msg);
}

function handleOpen() {
  //클라이언트 쪽에서 열렸을때 작동.
  console.log("Connected to Server");
}

socket.addEventListener("open", handleOpen);

//클라이언트 쪽에서 메세지 받았을 때 작동.
socket.addEventListener("message", (message) => {
  const li = document.createElement("li");
  li.innerText = message.data;
  messageList.append(li);
});

//클라이언트 쪽에서 연결이 닫혔을 때 작동.
socket.addEventListener("close", () => {
  console.log("Disconnected from server");
});

function handleSubmit(event) {
  event.preventDefault();
  const input = messageForm.querySelector("input");
  socket.send(makeMessage("new_message", input.value));
  input.value = "";
}

function handleNickSubmit(event) {
  event.preventDefault();
  const input = nickForm.querySelector("input");
  socket.send(makeMessage("nickname", input.value));
  input.value = "";
}

messageForm.addEventListener("submit", handleSubmit);
nickForm.addEventListener("submit", handleNickSubmit);
