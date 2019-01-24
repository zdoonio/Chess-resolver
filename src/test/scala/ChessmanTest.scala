import game.Game
import game.board.ChessBoard
import game.pieces.{ChessPiece, Chessman}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by Dominik Zduńczyk on 25.01.19.
  */
class ChessmanTest extends FlatSpec with Matchers {

  "King" should "be able to move" in {

    val board = ChessBoard(7,7)
    val king = ChessPiece(Chessman.KING)

    king.allMovementOptions(4,4, Game(board, List(king))) should be
    List((3, 3), (3, 4), (3, 5), (4, 3), (4, 5), (5, 3), (5, 4), (5, 5))
  }

  "Knight" should "be able to move" in {

    val board = ChessBoard(7,7)
    val knight = ChessPiece(Chessman.KNIGHT)

    knight.allMovementOptions(4,4, Game(board, List(knight))) should be
    List((2, 3), (2, 5), (3, 2), (3, 6), (5, 2), (5, 6), (6, 3), (6, 5))
  }

}
