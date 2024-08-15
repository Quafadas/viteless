//> using scala 3.4.2
//> using platform js

//> using dep org.scala-js::scalajs-dom::2.8.0
//> using dep com.raquo::laminar::17.0.0
//> using dep io.github.quafadas::dedav_laminar::0.9.2-1-05a8a88-20240725T191744Z-SNAPSHOT

//> using jsEmitSourceMaps true
//> using jsModuleKind es
//> using jsModuleSplitStyleStr smallmodulesfor
//> using jsSmallModuleForPackage webapp
//> using jsEsModuleImportMap importmap.json


package webapp

import org.scalajs.dom
import org.scalajs.dom.document
import com.raquo.laminar.api.L.{*, given}
import viz.vega.plots.PieChart
import viz.vega.plots.doNothing
import viz.vega.plots.PieChartLite
import viz.LaminarViz
import viz.vega.facades.EmbedOptions

@main
def main: Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    app
  )

def app =
  val hiVar = Var("Scala JS") // Local state
  div(
    h1(
      s"Hello ",
      child.text <-- hiVar.signal
    ),
    p("This page should reload on change  Check the justfile... asdf  "),
    // https://demo.laminar.dev/app/form/controlled-inputs
    input(
      typ := "text",
      controlled(
        value <-- hiVar.signal,
        onInput.mapToValue --> hiVar.writer
      )
    ),
    div(
      width := "50vmin",
      height := "50vmin",
      LaminarViz.simpleEmbed(
        PieChart(
          List(
            viz.Utils.fillDiv,
            spec => spec("marks")(0)("name") = "piedy"
          )
        ),
        embedOpt = Some(
          EmbedOptions( renderer = "svg" )
        )
      )
    ),

    notwebapp.more

  )
