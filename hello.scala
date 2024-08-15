//> using scala 3.4.2
//> using platform js

//> using dep org.scala-js::scalajs-dom::2.8.0
//> using dep com.raquo::laminar::17.1.0

//> using jsModuleKind es
//> using jsModuleSplitStyleStr smallmodulesfor
//> using jsSmallModuleForPackage webapp

// To resolve JS Deps
//> using jsEsModuleImportMap importmap.json

package webapp

import org.scalajs.dom
import org.scalajs.dom.document
import com.raquo.laminar.api.L.{*, given}

@main
def main: Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    div(
      app
    )
  )

def app =
    val s = new Tone.Synth().toDestination()
    div(
      h1("Hello, Tone.js!"),
        button("Play a note",
        onClick.mapTo(s) --> Observer[Tone.Synth]{_.triggerAttackRelease("C4", "8n") }
      )
    )


