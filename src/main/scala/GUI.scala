import hevs.graphics.FunGraphics
import hevs.graphics.utils.GraphicsBitmap
import java.awt.Color

class GUI {

  def textTitle(w: FunGraphics): Unit = {
    // val hei_defr = new GraphicsBitmap("/src/res/images/hei-defr.png")
    // val isc_icon = new GraphicsBitmap("/src/res/images/isc_icon.png")

    w.setColor(Color.lightGray)
    w.drawFillRect(0, 0, 700, 700)
    w.drawFancyString(103, 325, "Memory", Color.gray, 110)
    w.drawFancyString(100, 330, "Memory", Color.black, 110)
    w.drawFancyString(90, 600, "2024 by S.J. Cruz Go & U. Küleçi", Color.black, 30)
    //w.drawFancyString(110, 670, "ISC 1 - HES-SO Valais-Wallis", Color.black, 30)

    // w.drawTransformedPicture(200, 650, 0, 0.7, isc_icon)
    // w.drawTransformedPicture(450, 650, 0, 0.7, hei_defr)
  }

  def textPressStart(w: FunGraphics, posx: Int, posy: Int): Unit = {
    w.drawFancyString(posx + 3, posy - 5, "Press > s < to start", Color.gray, 40)
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
  
    w.drawFancyString(posx, posy, "Press > s < to start", Color.black, 40)
  }

  def selectDiff(w: FunGraphics): Unit = {
    // Background of the menu
    w.drawFillRect(0, 0, 710, 710)

    // Select difficulty text
    w.drawFancyString(110, 200, "Select difficulty", Color.gray, 60)
    w.drawFancyString(113, 195, "Select difficulty", Color.black, 60)
    w.drawFancyString(200, 250, "(Press 1, 2 or 3)", Color.black, 35)
    w.drawFancyString(70, 350, "1 - Easy", Color.black, 40)
    w.drawFancyString(70, 450, "2 - Medium", Color.black, 40)
    w.drawFancyString(70, 550, "3 - Hard", Color.black, 40)
  }

  def easyMode(w: FunGraphics, shuffledEasyBoard: Array[Array[Color]]): Unit = {
    var r: Int = 10
    var c: Int = 10
    val revealedBoard: Array[Array[Color]] = new Array[Array[Color]](shuffledEasyBoard.length - 1)


    // Clean Background
    w.drawFillRect(0, 0, 700, 700)

    // Draw an empty board
    for(a <- shuffledEasyBoard.indices; b <- shuffledEasyBoard(a).indices){
      w.setColor(Color.white)
      w.drawFillRect(c, r, 90, 90)
      if(c < 600) c += 100
      else if (c == 610) {
        r += 100
        c = 10
      }     
    }


    // Draw the board in the game
    // for(a <- shuffledEasyBoard.indices; b <- shuffledEasyBoard(a).indices){
    //   w.setColor(shuffledEasyBoard(a)(b))
    //   w.drawFillRect(c, r, 90, 90)
    //   if(c < 600) c += 100
    //   else if (c == 610) {
    //     r += 100
    //     c = 10
    //   }     
    // }
  }



  


}
