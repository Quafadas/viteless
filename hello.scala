//> using scala 3.4.2
//> using platform js

//> using dep org.scala-js::scalajs-dom::2.8.0
//> using dep com.raquo::laminar::17.0.0

//> using jsModuleKind es
//> using jsModuleSplitStyleStr smallmodulesfor
//> using jsSmallModuleForPackage webapp
//> using jsEmitSourceMaps true
//> using jsEsModuleImportMap importmap.json

//> using dep io.github.quafadas::peer-scalajs::0.0.3


package webapp

import org.scalajs.dom
import org.scalajs.dom.document
import com.raquo.laminar.api.L.{*, given}
import io.github.quafadas.peerscalajs.Peer
import io.github.quafadas.peerscalajs.DataConnection

import scala.scalajs.js

@main
def main: Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    app
  )

def app =
  val hiVar = Var("Simon")
  val connectToVar = Var("simon2")
  val sendMessageVar = Var("")
  val dataConnection = Var[Option[DataConnection]](None)

  val dataConnectionSignal = dataConnection.signal.map(_.map(_.on("data", (data: js.Any) => {
    println(s"Received data: $data")
  })))

  val peer = hiVar.signal.map { id =>
    val p = new Peer(id = id)
    p.on("connection", (data: DataConnection) => {

        data.on("data", (data: js.Object) => {
          println(s"Received data: ${js.JSON.stringify(data)}")
        })
        dataConnection.set(Some(data))
        println(s"Received data connection from ${data.peer}")
    })
    p
  }

  val connectionPair = peer.combineWith(connectToVar.signal)

  div(
    h1(
      s"",
      child.text <-- hiVar.signal
    ),
    p(
      child.text <-- peer.map{p => s"Your peer id is ${p.id}"}
    ),
    // https://demo.laminar.dev/app/form/controlled-inputs
    p(input(
      typ := "text",
      controlled(
        value <-- hiVar.signal,
        onInput.mapToValue --> hiVar.writer
      )
    )),
    p(
      s"Connect to peer with id"
    ),
    p(input(
      typ := "text",
      controlled(
        value <-- connectToVar.signal,
        onInput.mapToValue --> connectToVar.writer
      )
    ),
      "establish connection",
      connectionPair--> Observer[(Peer, String)]{
        case (p, inId) =>
          val data = p.connect(inId)
          data.on("data", (data: js.Object) => {
            println(s"Received data: ${js.JSON.stringify(data)}")
          })
          dataConnection.set(Some(data))
      }
    ),
    p(
      "send this message to the connected peer",
      input(
      typ := "text",
      controlled(
        value <-- sendMessageVar.signal,
        onInput.mapToValue --> sendMessageVar.writer
      )
    )),

    dataConnection.signal.combineWith(sendMessageVar.signal)  -->
    Observer[(Option[DataConnection], String)]{
        case (dataConn, msg) =>
          println(s"sending message: $msg")
          dataConn.foreach(_.send(msg))
    }




  )
