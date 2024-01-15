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

          // Adding a mouse listener
          w.addMouseListener(new MouseAdapter() {
            override def mouseClicked(e: MouseEvent): Unit = {
              val event = e
              val posx = event.getX
              val posy = event.getY

              // Checking posx and posy
              var r: Int = 10
              var c: Int = 10
              var choices: Int = 2

              // First row
              if(posy < 100 && choices == 2) {
                if(posx < 100) {
                  interface.drawRect(shuffledEasyBoard, w, 0, 0, c, r)
                  choices -= 2
                }
                else if(posx < 200) {
                  interface.drawRect(shuffledEasyBoard, w, 1, 0, c + 100, r)
                  choices -= 2
                }
                else if(posx < 300){
                  interface.drawRect(shuffledEasyBoard, w, 2, 0, c + 200, r)
                }
                else if(posx < 400) {
                  interface.drawRect(shuffledEasyBoard, w, 3, 0, c + 300, r)
                }
                else if(posx < 500) {
                  interface.drawRect(shuffledEasyBoard, w, 4, 0, c + 400, r)
                }
                else if(posx < 600) {
                  interface.drawRect(shuffledEasyBoard, w, 5, 0, c + 500, r)
                }
                else if(posx < 700) {
                  interface.drawRect(shuffledEasyBoard, w, 6, 0, c + 600, r)
                }
              }
               // Second row
               if(posy > 100 && posy < 200) {
                if(posx < 100) {
                  interface.drawRect(shuffledEasyBoard, w, 0, 1, c, r + 100)
                }
                else if(posx < 200) {
                  interface.drawRect(shuffledEasyBoard, w, 1, 1, c + 100, r + 100)
                }
                else if(posx < 300){
                  interface.drawRect(shuffledEasyBoard, w, 2, 1, c + 200, r + 100)
                }
                else if(posx < 400) {
                  interface.drawRect(shuffledEasyBoard, w, 3, 1, c + 300, r + 100)
                }
                else if(posx < 500) {
                  interface.drawRect(shuffledEasyBoard, w, 4, 1, c + 400, r + 100)
                }
                else if(posx < 600) {
                  interface.drawRect(shuffledEasyBoard, w, 5, 1, c + 500, r + 100)
                }
                else if(posx < 700) {
                  interface.drawRect(shuffledEasyBoard, w, 6, 1, c + 600, r + 100)
                }
              }

               // Third row
               if(posy > 200 && posy < 300) {
                if(posx < 100) {
                  interface.drawRect(shuffledEasyBoard, w, 0, 2, c, r + 200)
                }
                else if(posx < 200) {
                  interface.drawRect(shuffledEasyBoard, w, 1, 2, c + 100, r + 200)
                }
                else if(posx < 300){
                  interface.drawRect(shuffledEasyBoard, w, 2, 2, c + 200, r + 200)
                }
                else if(posx < 400) {
                  interface.drawRect(shuffledEasyBoard, w, 3, 2, c + 300, r + 200)
                }
                else if(posx < 500) {
                  interface.drawRect(shuffledEasyBoard, w, 4, 2, c + 400, r + 200)
                }
                else if(posx < 600) {
                  interface.drawRect(shuffledEasyBoard, w, 5, 2, c + 500, r + 200)
                }
                else if(posx < 700) {
                  interface.drawRect(shuffledEasyBoard, w, 6, 2, c + 600, r + 200)
                }
              }

               // Fourth row
               if(posy > 300 && posy < 400) {
                if(posx < 100) {
                  interface.drawRect(shuffledEasyBoard, w, 0, 3, c, r + 300)
                }
                else if(posx < 200) {
                  interface.drawRect(shuffledEasyBoard, w, 1, 3, c + 100, r + 300)
                }
                else if(posx < 300){
                  interface.drawRect(shuffledEasyBoard, w, 2, 3, c + 200, r + 300)
                }
                else if(posx < 400) {
                  interface.drawRect(shuffledEasyBoard, w, 3, 3, c + 300, r + 300)
                }
                else if(posx < 500) {
                  interface.drawRect(shuffledEasyBoard, w, 4, 3, c + 400, r + 300)
                }
                else if(posx < 600) {
                  interface.drawRect(shuffledEasyBoard, w, 5, 3, c + 500, r + 300)
                }
                else if(posx < 700) {
                  interface.drawRect(shuffledEasyBoard, w, 6, 3, c + 600, r + 300)
                }
              }
               // Fifth row
               if(posy > 400 && posy < 500) {
                if(posx < 100) {
                  interface.drawRect(shuffledEasyBoard, w, 0, 4, c, r + 400)
                }
                else if(posx < 200) {
                  interface.drawRect(shuffledEasyBoard, w, 1, 4, c + 100, r + 400)
                }
                else if(posx < 300){
                  interface.drawRect(shuffledEasyBoard, w, 2, 4, c + 200, r + 400)
                }
                else if(posx < 400) {
                  interface.drawRect(shuffledEasyBoard, w, 3, 4, c + 300, r + 400)
                }
                else if(posx < 500) {
                  interface.drawRect(shuffledEasyBoard, w, 4, 4, c + 400, r + 400)
                }
                else if(posx < 600) {
                  interface.drawRect(shuffledEasyBoard, w, 5, 4, c + 500, r + 400)
                }
                else if(posx < 700) {
                  interface.drawRect(shuffledEasyBoard, w, 6, 4, c + 600, r + 400)
                }
              }
               // Sixth row
               if(posy > 500 && posy < 600) {
                if(posx < 100) {
                  interface.drawRect(shuffledEasyBoard, w, 0, 5, c, r + 500)
                }
                else if(posx < 200) {
                  interface.drawRect(shuffledEasyBoard, w, 1, 5, c + 100, r + 500)
                }
                else if(posx < 300){
                  interface.drawRect(shuffledEasyBoard, w, 2, 5, c + 200, r + 500)
                }
                else if(posx < 400) {
                  interface.drawRect(shuffledEasyBoard, w, 3, 5, c + 300, r + 500)
                }
                else if(posx < 500) {
                  interface.drawRect(shuffledEasyBoard, w, 4, 5, c + 400, r + 500)
                }
                else if(posx < 600) {
                  interface.drawRect(shuffledEasyBoard, w, 5, 5, c + 500, r + 500)
                }
                else if(posx < 700) {
                  interface.drawRect(shuffledEasyBoard, w, 6, 5, c + 600, r + 500)
                }
              }
              
              if(choices == 0) {
                println("Choices = 0")
                // if()
                choices = 2
              }




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
