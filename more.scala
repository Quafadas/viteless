package webapp

import com.raquo.laminar.api.L.{*, given}

def more = div(
  p(
    "You can choose to add more stuff in other files to structure the project more properly."
  ),
  p("It's just another scala-cli project and will respect all it's flags etc"),
  p("Check the other branches for some more flags..."),
  p("Now we also have SPA routing... "),
  p("And... styles... The styles should refresh without a page reload..."),
  p("just to make the point that you can server pictures out the same asdset dir"),
  img(src := "/dots1.png", width := "100", height := "100")
)
