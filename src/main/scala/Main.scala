import hevs.graphics.FunGraphics
import hevs.graphics.utils.GraphicsBitmap
import java.awt.event.{KeyAdapter, KeyEvent}
import java.awt.Color

object Main extends App  {
  var c: Int = 700
  var r: Int = 700

  val w: FunGraphics = new FunGraphics(700, 700, "Memory, 2024 by UK & SJCG - ISC")
  var started: Boolean = false
  var gameOver: Boolean = false
  var ok: Boolean = false // Created to avoid problems with the keyboard setter
  var allowDiffSelection: Boolean = false // If true, allows the player to choose a difficulty

  new GUI textTitle(w)
  new GUI textPressStart(w, 150, 420)
  
  // val board: Array[Array[Int]] = Array.empty
  // var r: Int = 700
  // var c: Int = 700
  //
  // for(i <- 0 to c) {
  //   for(j <- 0 to r) {
  //     w.setColor(Color.lightGray)
  //     w.drawFilledCircle((i*100)+5, (j*100)+105, 90)
  //   }
  // }
  
  if(started) println("Hello")
  // Keyboard control
  w.setKeyManager(new KeyAdapter() {
      override def keyPressed(e: KeyEvent): Unit = {
        ok = true
        if (e.getKeyChar == 's') {
          started = true
          ok = false
          allowDiffSelection = true
          new GUI selectDiff(w)
        }
        else if (e.getKeyChar == '1' && allowDiffSelection) println("You chose 1")
        else if (e.getKeyChar == '2' && allowDiffSelection) println("You chose 2")
        else if (e.getKeyChar == '3' && allowDiffSelection) println("You chose 3")
      }
  })



 


}
