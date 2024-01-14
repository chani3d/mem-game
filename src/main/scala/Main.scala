import hevs.graphics.FunGraphics
import hevs.graphics.utils.GraphicsBitmap
import java.awt.event.{KeyAdapter, KeyEvent, MouseAdapter, MouseEvent}
import java.awt.Color
import scala.util.Random

object Main extends App  {
  val interface: GUI = new GUI
  var random: Random = new Random()
  var randomRow: Int = 0
  var randomColumn: Int = 0
  var c: Int = 700
  var r: Int = 700
  var time: Int = 0
  val w: FunGraphics = new FunGraphics(710, 710, "Memory, 2024 by UK & SJCG - ISC")
  var started: Boolean = false
  var gameOver: Boolean = false
  var ok: Boolean = false // Created to avoid problems with the keyboard setter
  var allowDiffSelection: Boolean = false // If true, allows the player to choose a difficulty

  interface.textTitle(w)
  interface.textPressStart(w, 150, 420)
  
    // Keyboard control
  w.setKeyManager(new KeyAdapter() {
      override def keyPressed(e: KeyEvent): Unit = {
        ok = true
        if (e.getKeyChar == 's') {
          started = true
          ok = false
          allowDiffSelection = true
          interface.selectDiff(w)
        }

        // Easy mode
        else if (e.getKeyChar == '1' && allowDiffSelection) {
          val easyBoard: Array[Array[Color]] = Array.ofDim[Color](6, 7)
          val colorBoard: Array[Color] = new Array[Color](21)
          
          // Stores random colors in the colorBoard
          for(i <- colorBoard.indices) {
            var randomColor: Color = Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))
            colorBoard(i) = randomColor
          }

          // Stores the colors in the main game board
          var c: Int = 0 
          for(i <- easyBoard.indices){
            for(j <- easyBoard(i).indices) {
              if(c != 21) {
                easyBoard(i)(j) = colorBoard(c)
                c += 1
              }
              else {
                c = 0
                easyBoard(i)(j) = colorBoard(0)
                c += 1
              }
            }
          }
          val shuffledEasyBoard = Random.shuffle(easyBoard.toSeq).toArray
       
          // Check colors in easyBoard
          var lines: Int = 0 
          for(i <- easyBoard.indices) {
            for(j <- easyBoard(i).indices){
              println(s"${lines}. ${easyBoard(i)(j)}")
              lines += 1
            }
          }
          interface.easyMode(w, shuffledEasyBoard) // Initialize the easy mode

          // Ading a mouse listener
          w.addMouseListener(new MouseAdapter() {
            override def mouseClicked(e: MouseEvent): Unit = {
              val event = e
              val posx = event.getX
              val posy = event.getY

              println(s"Mouse position $posx - $posy")
            }
          })


        /* What to do : Create if statements to check the position captured by the
         * mouse event */
        }
        
        // Medium mode
        else if (e.getKeyChar == '2' && allowDiffSelection) println("You chose 2")

        // Hard mode
        else if (e.getKeyChar == '3' && allowDiffSelection) println("You chose 3")
      }
  })



 


}
