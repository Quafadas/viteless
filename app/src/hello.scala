package webapp

import org.scalajs.dom
import org.scalajs.dom.document
import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.{*, given}
import io.github.nguyenyou.webawesome.laminar.*

@main
def main: Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    app
  )

def app =
  val hiVar = Var("Simon") // Local state

  div(
    cls := "page-container",
    div(
      cls := "page-header",
      h1("Hello ", child.text <-- hiVar.signal)
    ),
    p("This page should reload on change"),
    Callout(
      _.slots.icon(Icon(_.name := "circle-info")())
    )(
      "Quickly"
    ),
    p(),
    input(
      typ := "text",
      controlled(
        value <-- hiVar.signal,
        onInput.mapToValue --> hiVar.writer
      )
    ),
    p("does'nt make the bind a second time? "),
    ul(
      li(
        "This reloads on change to source.",
        ul(
          li("Sources are hashed and served with `public, immutable` headers, so only the changed files are reloaded. Others served out of browser cache"),
          li("Mill provides a ", pre("Map[String, Array[Byte]]"), " to the linker and injects that map into the refresh server. No file I/O during fastLinkJS / refresh loop"),
        )
      ),
      li("Source maps are configured and one click away in Chrome Devtools."),
      li("Styles hot reload"),
      li("Single publish command"),
      pre(
        """mill show app.publish""".stripMargin
      )
    )
  )
