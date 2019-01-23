package game.board

/**
  * Created by dominik.zdunczyk on 23.01.19.
  */
import helper.Utils

/**
  * Chess board
  * @param rows     number of rows
  * @param columns  number of columns
  */
case class ChessBoard(
  var rows: Int,
  var columns: Int
)

object ChessBoard {

  /**
    * Generate chess board
    *
    */
  def generate: ChessBoard = {
    val rows = Utils.readValueOf("Enter number of board rows: ", min = 0, max = 999)
    val columns = Utils.readValueOf("Enter number of board columns: ", min = 0, max = 18278)
    ChessBoard(rows, columns)
  }
}