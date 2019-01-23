package helper

import scala.io.StdIn

/**
  * Created by dominik.zdunczyk on 23.01.19.
  */
object Utils {


  /**
    * Prints a prompt and then reads an Integer
    * @param prompt message
    * @param min minimal input number
    * @param max maximum input number
    * @return integer number
    */
  def readBoardSize(prompt: String, min: Int = Int.MinValue, max: Int = Int.MaxValue): Int = {
    printf(prompt)
    try {
      StdIn.readInt() match {

        case input if input < min =>
          println(s"Number '$input' is to low, minimum is $min")
          readBoardSize(prompt, min, max)

        case input if input > max =>
          println(s"Number '$input' is to high, maximum is $max")
          readBoardSize(prompt, min, max)

        case input =>
          input
      }
    } catch { case e: Exception =>
      println(s"Error ${e.getMessage}")
      readBoardSize(prompt, min, max)
    }
  }
}
