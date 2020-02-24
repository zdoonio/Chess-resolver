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
case class ChessBoard(rows: Int, columns: Int)

object ChessBoard {

  /**
    * Generate chess board with rows and columns
    *
    */
  def generate: ChessBoard = {
    ChessBoard(Utils.readValueOf("Enter number of board rows: ", min = 0, max = 999),
      Utils.readValueOf("Enter number of board columns: ", min = 0, max = 18278))
  }
}