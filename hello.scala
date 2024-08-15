//> using scala 3.4.2
//> using platform js

//> using dep org.scala-js::scalajs-dom::2.8.0
//> using dep com.raquo::laminar::17.0.0
//> using dep com.raquo::waypoint::8.0.0
//> using dep com.lihaoyi::upickle::3.3.1
//> using dep com.raquo::laminar-shoelace::0.1.0

//> using jsModuleKind es
//> using jsModuleSplitStyleStr smallmodulesfor
//> using jsSmallModuleForPackage webapp

// To resolve JS Deps
//> using jsEsModuleImportMap importmap.json

package webapp

import org.scalajs.dom
import org.scalajs.dom.document
import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.{*, given}
import com.raquo.waypoint._
import upickle.default._
import com.raquo.laminar.shoelace.sl.Badge
import com.raquo.laminar.shoelace.sl.CommonKeys.variant
import com.raquo.laminar.shoelace.sl.Include
import com.raquo.laminar.shoelace.sl.Menu
import com.raquo.laminar.shoelace.sl.MenuItem

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


