//> using scala 3.6.4
//> using platform js

//> using dep org.scala-js::scalajs-dom::2.8.0
//> using dep io.github.quafadas::dedav_laminar::0.9.2

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
import scala.scalajs.js.annotation.JSImport

@main
def main: Unit =

  dom.document.addEventListener(
    "DOMContentLoaded",
    { (_: dom.Event) =>
      initializeECharts()

      // child.setAttribute("style", s"width:500px;height:500px")

    }
  )

def initializeECharts(): Unit =
  val chartDiv = dom.document.createElement("div")
  chartDiv.id = "main"
  chartDiv.setAttribute("style", "width: 600px; height: 400px;")
  dom.document.getElementById("app").appendChild(chartDiv)

  val myChart = echarts.init(chartDiv)

  val opt = js.Dynamic.literal(
    title = js.Dynamic.literal(
      text = "ECharts Getting Started Example"
    ),
    tooltip = js.Dynamic.literal(),
    width = 600,
    height = 400,
    legend = js.Dynamic.literal(
      data = js.Array("sales")
    ),
    xAxis = js.Dynamic.literal(
      data = js.Array("Shirts", "Cardigans")
    ),
    yAxis = js.Dynamic.literal(),
    series = js.Array(
      js.Dynamic.literal(
        name = "sales",
        `type` = "bar",
        data = js.Array(5, 20)
      )
    )
  )

  myChart.setOption(opt)

// import * as echarts from "echarts/dist/echarts";
@js.native
@JSImport(
  "https://cdn.jsdelivr.net/npm/echarts@5.6.0/dist/echarts.esm.js",
  JSImport.Namespace
)
object echarts extends js.Object:
  def init(dom: Element): EChartInstance = js.native
  def init(dom: Element, theme: String): EChartInstance = js.native

@js.native
trait EChartInstance extends js.Object:
  def setOption(option: js.Dynamic): Unit = js.native
  def resize(): Unit = js.native
