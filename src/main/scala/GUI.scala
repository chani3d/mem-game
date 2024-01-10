import hevs.graphics.FunGraphics
import hevs.graphics.utils.GraphicsBitmap

import java.awt.Color
import java.awt.event.{KeyAdapter, KeyEvent}
import java.util.Timer
import scala.math.random
import scala.util.Random

class GUI {

  val w : FunGraphics = new FunGraphics(700, 700, "Memory, 2024 by UK & SJCG - ISC")
  val board: Array[Array[Int]] = Array.empty

  // Taille de GUI
  var time: Int = 0
  var started: Boolean = false
  var gameOver: Boolean = false
  var ok: Boolean = false // Created to avoid problems with the keyboard setter
  var allowDiffSelection: Boolean = false // If true, allows the player to choose a difficulty

  textTitle(w)
  textPressStart(w, 150, 420)

  def textTitle(w: FunGraphics): Unit = {
    w.setColor(Color.lightGray)
    w.drawFillRect(0, 0, 700, 700)
    w.drawFancyString(103, 325, "Memory", Color.gray, 110)
    w.drawFancyString(100, 330, "Memory", Color.black, 110)
    w.drawFancyString(90, 600, "2024 by S.J. Cruz Go & U. Küleçi", Color.black, 30)
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

  // Stores to colors
  val easyBoard: Array[Color] = new Array[Color](8)
  val mediumBoard: Array[Color] = new Array[Color](18)
  val hardBoard: Array[Color] = new Array[Color](32)

  def easyMode(w: FunGraphics): Unit = {
    // Reset the Background
    w.drawFillRect(0, 0, 700, 700)
    val squareSize = 165
    val margin = (700 - 4 * squareSize) / 5 // Hesaplanan margin değeri
    val rows = 4
    val cols = 4

    // Creates a color 8 times for the easy board
    for (i <- 0 until easyBoard.length) {
      val randomColor: Color = new Color(Random.between(0, 255), Random.between(0, 255), Random.between(0, 255))
      easyBoard(i) = randomColor
    }

    // Liste d'index pour les couples
    val pairIndices = Random.shuffle(Array.range(0, easyBoard.length) ++ Array.range(0, easyBoard.length))
    // pairIndices.foreach(index => println(index)) todo  <- this line will delete, after

    for (i <- 0 until rows) {
      for (j <- 0 until cols) {
        val x = i * (squareSize + margin) + margin
        val y = j * (squareSize + margin) + margin
        val colorIndex = pairIndices(i * cols + j)
        w.setColor(easyBoard(colorIndex)) // Renkleri karıştırılmış listeden al
        w.drawFillRect(x, y, squareSize, squareSize)
      }
    }
  }

  def mediumMode(w: FunGraphics): Unit = {
    // Reset the Background
    w.drawFillRect(0, 0, 700, 700)
    val squareSize = 110
    val margin = (700 - 6 * squareSize) / 7
    val rows = 6
    val cols = 6

    for (i <- 0 until mediumBoard.length) {
      val randomColor: Color = new Color(Random.between(0, 255), Random.between(0, 255), Random.between(0, 255))
      mediumBoard(i) = randomColor
    }

    val pairIndices = Random.shuffle(Array.range(0, mediumBoard.length) ++ Array.range(0, mediumBoard.length))

    for (i <- 0 until rows) {
      for (j <- 0 until cols) {
        val x = i * (squareSize + margin) + margin
        val y = j * (squareSize + margin) + margin
        val colorIndex = pairIndices(i * cols + j)
        w.setColor(mediumBoard(colorIndex)) // Renkleri karıştırılmış listeden al
        w.drawFillRect(x, y, squareSize, squareSize)
      }
    }
  }

  def hardMode(w: FunGraphics): Unit = {
    // Reset the Background
    w.drawFillRect(0, 0, 700, 700)
    val squareSize = 85
    val margin = (700 - 8 * squareSize) / 9 // Hesaplanan margin değeri
    val rows = 8
    val cols = 8

    for (i <- 0 until hardBoard.length) {
      val randomColor: Color = new Color(Random.between(0, 255), Random.between(0, 255), Random.between(0, 255))
      hardBoard(i) = randomColor
    }

    val pairIndices = Random.shuffle(Array.range(0, hardBoard.length) ++ Array.range(0, hardBoard.length))

    for (i <- 0 until rows) {
      for (j <- 0 until cols) {
        val x = i * (squareSize + margin) + margin
        val y = j * (squareSize + margin) + margin
        val colorIndex = pairIndices(i * cols + j)
        w.setColor(hardBoard(colorIndex)) // Renkleri karıştırılmış listeden al
        w.drawFillRect(x, y, squareSize, squareSize)
      }
    }
  }

  def allWhite(w: FunGraphics, numberOfLinesAndCols: Int, squareSize: Int): Unit = {
    w.drawFillRect(0, 0, 700, 700)
    val margin = (700 - numberOfLinesAndCols * squareSize) / numberOfLinesAndCols + 1
    for (i <- 0 until numberOfLinesAndCols) {
      for (j <- 0 until numberOfLinesAndCols) {
        val x = i * (squareSize + margin) + margin
        val y = j * (squareSize + margin) + margin
        w.setColor(Color.white)
        w.drawFillRect(x, y, squareSize, squareSize)
      }
    }
  }

  // Keyboard control
  w.setKeyManager(new KeyAdapter() {
    override def keyPressed(e: KeyEvent): Unit = {

      var a: Char = 'a'
      ok = true
      if (e.getKeyChar == 's') {
        started = true
        ok = false
        allowDiffSelection = true
        selectDiff(w)

        // EASY MODE STARTING POINT
      } else if (e.getKeyChar == '1' && allowDiffSelection) {
        a = '1'
        easyMode(w)
        println("You chose 1")
        Thread.sleep(1000)  // TODO = CHANGE THE TIME FOR EACH MODE. it must be diffrent
        allWhite(w,4,165)


      // MEDIUM MODE STARTING POINT
      } else if (e.getKeyChar == '2' && allowDiffSelection) {
        a = '2'
        mediumMode(w)
        println("You chose 2")
        Thread.sleep(1000)
        allWhite(w, 6, 110)

      // HARD MODE STARTING POINT AND SETTINGS
      } else if (e.getKeyChar == '3' && allowDiffSelection) {
        a = '3'
        hardMode(w)
        println("You chose 3")
        Thread.sleep(1000)
        allWhite(w, 8, 85)

      }
    }
  })


} // End if the GUI class

