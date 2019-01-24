package game

/**
  * Created by dominik.zdunczyk on 23.01.19.
  */

import game.board.ChessBoard
import game.pieces.{ChessPiece, Chessman}

/**
  * Game parameters
  * @param board  board dimensions
  * @param pieces list of chess pieces
  */
case class Game (
  board: ChessBoard,
  pieces: List[ChessPiece]
)

object Game {

  /**
    * Initializes game setting up the board and pieces
    * @return game object
    */
  def init: Game = {
    val board = ChessBoard.generate
    val pieces = Chessman.values.toList.flatMap { pieceType =>
      ChessPiece.init(pieceType)
    }

    Game(board, pieces)
  }
}
