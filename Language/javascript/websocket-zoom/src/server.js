import http from "http";
import WebSocket from "ws";
import express from "express";

const app = express();

app.set("view engine", "pug");
app.set("views", __dirname + "/views");
app.use("/public", express.static(__dirname + "/public"));
app.get("/", (req, res) => res.render("home"));
const handleListen = () => console.log(`Listening on http://localhost:3000`);

const server = http.createServer(app);
const wss = new WebSocket.Server({ server }); // 같은 포트(3000)에서 http, ws server 두개 모두 동작하도록 설정.

function onSocketClose() {
  console.log("Disconnected from the Browser ❌");
}

//face db 몇 명의 클라이언트가 붙었는지 저장함.
const sockets = [];

// 클라이언트-서버 연결되면(connection) fn 실행.
wss.on("connection", (socket) => {
  sockets.push(socket); // 새로 연결된 소켓 저장.
  socket["nickname"] = "Anon";
  console.log("Connected to Browser ✅");
  socket.on("close", onSocketClose);
  socket.on("message", (msg) => {
    const message = JSON.parse(msg);
    switch (message.type) {
      case "new_message":
        sockets.forEach((aSocket) =>
          aSocket.send(`${socket.nickname}: ${message.payload}`)
        );
        break;
      case "nickname":
        socket["nickname"] = message.payload;
        break;
    }
  });
});

server.listen(3000, handleListen);
