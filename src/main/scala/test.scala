import scala.util.Random
import java.awt.Color

object test extends App {

  //  // Original array with 4 elements
  // val originalArray = Array("item1", "item2", "item3", "item4")
  //
  // // Shuffle the original array
  // val shuffledArray = Random.shuffle(originalArray.toSeq).toArray
  //
  // // Create a new array with a length of 8
  // val newArray = new Array[String](8)
  //
  // // Copy the shuffled elements from the original array to the new array
  // System.arraycopy(shuffledArray, 0, newArray, 0, shuffledArray.length)
  // System.arraycopy(shuffledArray, 0, newArray, shuffledArray.length, shuffledArray.length)
  //
  // // Print the resulting array
  // println(newArray.mkString(", "))

  val easyBoard: Array[Array[Color]] = Array.ofDim[Color](6, 7)
  val colorBoard: Array[Color] = new Array[Color](21)
  var random: Random = new Random()

  for(i <- colorBoard.indices) {
    var randomColor: Color = Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))
    colorBoard(i) = randomColor
  }
  
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

  var lines: Int = 0 
  for(i <- easyBoard.indices) {
    for(j <- easyBoard(i).indices){
      println(s"${lines}. ${easyBoard(i)(j)}")
      lines += 1
    }
  }
  

}

