//> using scala 3.4.2
//> using platform js

//> using dep org.scala-js::scalajs-dom::2.8.0
//> using dep io.github.quafadas::dedav_laminar::0.9.3

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
import viz.PlatformGetSpec
import viz.vega.Framework

import org.scalajs.dom
import scala.util.Random
import org.scalajs.dom.Element
import org.scalajs.dom.XMLHttpRequest
import scala.scalajs.js
import scala.scalajs.js.JSON
import org.scalajs.dom.HTMLDivElement

@main
def main: Unit =

  showJsDocs(
    "errorBars.vg.json",
    dom.document.getElementById("app")

  )

object showJsDocs:
  def apply(path: String, node: Element, width: Int = 50) =
    val child = dom.document.createElement("div")
    val anId = "vega" + Random.alphanumeric.take(8).mkString("")
    child.id = anId
    node.appendChild(child)
    child.setAttribute("style", s"width:${width}vmin;height:${width}vmin")

    val opts = viz.vega.facades.EmbedOptions()
    val xhr = new XMLHttpRequest()
    xhr.open("GET", s"$path", false)
    xhr.send()
    val text = xhr.responseText
    val parsed = JSON.parse(text).asInstanceOf[js.Object]
    viz.vega.facades.embed(child.asInstanceOf[HTMLDivElement], parsed, opts)
    ()
  end apply