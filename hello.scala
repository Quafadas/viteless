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

sealed trait Page derives ReadWriter
case class UserPage(userId: Int) extends Page derives ReadWriter
case object HomePage extends Page derives ReadWriter


val userRoute = Route(
  encode = (userPage: UserPage) => userPage.userId,
  decode = arg => UserPage(userId = arg),
  pattern = root / "app" / "user" / segment[Int] / endOfSegments
)

val homeRoute = Route.static(HomePage, root )

val router = new Router[Page](
  routes = List(userRoute, homeRoute),
  getPageTitle = _.toString, // mock page title (displayed in the browser tab next to favicon)
  serializePage = page => write(page), // serialize page data for storage in History API log
  deserializePage = pageStr => read(pageStr) // deserialize the above
)(
  popStateEvents = L.windowEvents(_.onPopState), // this is how Waypoint avoids an explicit dependency on Laminar
  owner = L.unsafeWindowOwner // this router will live as long as the window
)


val splitter = SplitRender[Page, HtmlElement](router.currentPageSignal)
  .collectSignal[UserPage] { userPageSignal => renderUserPage(userPageSignal) }
  .collectStatic(HomePage) { app }

@main
def main: Unit =
  renderOnDomContentLoaded(
    dom.document.getElementById("app"),
    div(
      child <-- splitter.signal
    )
  )

def app =
  val hiVar = Var("Scala JS") // Local state
  div(
    h1(
      s"Hello ",
      child.text <-- hiVar.signal
    ),
    pre("just dev"),
    p("And This page should reload on change. Check the justfile..."),
    // https://demo.laminar.dev/app/form/controlled-inputs
    input(
      typ := "text",
      controlled(
        value <-- hiVar.signal,
        onInput.mapToValue --> hiVar.writer
      )
    ),
    more,
    p("Also, we can use import maps, to resolve JS Deps ... like shoelace"),
    div(Badge("Yeyz", variant := "primary"),
      Badge("Success", variant := "success"),
    ),
    p(
    Menu(
      a(
        href := "/app/user/1", //  read waypoint docs to generate typesafe links.
        MenuItem("User 1")
      ),
      a(
        href := "/app/user/2",
        MenuItem(
          "User 2"
        )
      ),
    )
    )
  )

