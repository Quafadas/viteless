package webapp

import com.raquo.laminar.api.L
import com.raquo.laminar.api.L.{*, given}

def renderUserPage(userPageSignal: Signal[UserPage]): Div = {
  div(
    h1("Client side routing"),
    "User page ",
    child.text <-- userPageSignal.map(user => user.userId),
    p("This is a simple example of client side routing using Waypoint."),
    p("Note the change in the server config - client routes are served undernearth /app/..."),
    p("It's worth inspecting the network activity in the browser tools. This page loads index.html file, leaving the client side to handle these routes."),
    p("Getting the backend setup to do all can get tedious"),
  )
}
