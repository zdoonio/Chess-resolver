package game.pieces

/**
  * Created by dominik.zdunczyk on 23.01.19.
  */
import game.pieces.Chessman.Chessman
import helper.Utils

/**
  * Chess piece object
  * @param chessman  type of chessman
  */
case class ChessPiece(
  var chessman: Chessman
)

object ChessPiece {

  /**
    * Initializes number of game pieces of certain type
    * @param pieceType type of game piece
    * @return list of game pieces
    */
  def init(chessman: Chessman): List[ChessPiece] = {
    (1 to Utils.readValueOf(s"Enter number of ${chessman.toString.toLowerCase}s: ", min = 0)).map { i: Int =>
      ChessPiece(chessman)
    }.toList
  }
}