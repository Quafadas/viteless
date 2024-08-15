package webapp

import scala.scalajs.js
import scala.scalajs.js.annotation._



// Define the Tone object facade
@js.native
@JSImport("https://esm.run/tone@15.0.4", JSImport.Namespace)
object Tone extends js.Object {
  def start(): js.Promise[Unit] = js.native
  // val Transport: Transport = js.native
  @js.native
  // @JSGlobal("Tone.Synth")
  class Synth() extends js.Object {
    def toDestination(): Synth = js.native
    def triggerAttackRelease(note: String, duration: String): Unit = js.native
  }
}

// // Define the Synth class facade
// @js.native
// @JSGlobal("Tone.Synth")
// class Synth() extends js.Object {
//   def toDestination(): Synth = js.native
//   def triggerAttackRelease(note: String, duration: String): Unit = js.native
// }

// Define the Transport object facade
// @js.native
// @JSGlobal("Tone.Transport")
// class Transport extends js.Object {
//   def start(time: String = "0"): Unit = js.native
//   def stop(time: String = "0"): Unit = js.native
//   def schedule(callback: js.Function1[Double, Unit], time: String): Unit = js.native
// }