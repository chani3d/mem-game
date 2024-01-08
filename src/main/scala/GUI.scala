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
    w.drawFancyString(posx, posy, "Press > s < to start", Color.black, 40)
  }

  def selectDiff(w: FunGraphics): Unit = {
    // Background of the menu
    w.drawFillRect(0, 0, 700, 700)

    // Select difficulty text
    w.drawFancyString(110, 200, "Select difficulty", Color.gray, 60)
    w.drawFancyString(113, 195, "Select difficulty", Color.black, 60)
    w.drawFancyString(200, 250, "(Press 1, 2 or 3)", Color.black, 35)
    w.drawFancyString(70, 350, "1 - Easy", Color.black, 40)
    w.drawFancyString(70, 450, "2 - Medium", Color.black, 40)
    w.drawFancyString(70, 550, "3 - Hard", Color.black, 40)
  }



  


}
