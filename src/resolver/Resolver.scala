package resolver

import game.board.ChessBoard
import game.pieces.{ChessPiece, Chessman}

/**
  * Created by dominik.zdunczyk on 23.01.19.
  */
object Resolver extends App {

  override def main(args: Array[String]) = {
    println("Welcome in chess game resolver!")
    ChessBoard.generate
    Chessman.values.toList.flatMap { pieceType =>
      ChessPiece.init(pieceType)
    }
  }

}
