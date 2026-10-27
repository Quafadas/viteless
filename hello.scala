//> using scala 3.9.0
//> using platform js

//> using dep org.scala-js::scalajs-dom::2.8.1
//> using dep com.raquo::laminar::17.2.1
//> using dep io.github.nguyenyou::webawesome-laminar::3.14.1

//> using jsModuleKind es
//> using jsModuleSplitStyleStr smallmodulesfor
//> using jsSmallModuleForPackage webapp
//> using jsEmitSourceMaps true
//> using jsEsModuleImportMap importmap.json

package webapp

import org.scalajs.dom
import org.scalajs.dom.document
import com.raquo.laminar.api.L.{*, given}
import io.github.nguyenyou.webawesome.laminar.*

@main
def main: Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    app
  )

def app =
  
  div(    
    Button(
      _.variant.neutral,
      _.onClick --> { _ =>
        println("clikced")
      }
    )("New project"),    
  )
