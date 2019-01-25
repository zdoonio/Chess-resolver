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

  "Rook" should "be able to move" in {

    val board = ChessBoard(4,4)
    val rook = ChessPiece(Chessman.ROOK)

    rook.allMovementOptions(1,1, Game(board, List(rook))) should be
    List((1, 2), (1, 3), (1, 4), (2, 1), (3, 1), (4, 1))

  }

  "Bishop" should "be able to move" in {

    val board = ChessBoard(4,4)
    val bishop = ChessPiece(Chessman.BISHOP)

    bishop.allMovementOptions(1,1, Game(board, List(bishop))) should be
    List((2, 2), (3, 3), (4, 4))

  }

  "Queen" should "be able to move" in {

    val board = ChessBoard(4,4)
    val queen = ChessPiece(Chessman.QUEEN)

    queen.allMovementOptions(1, 1, Game(board, List(queen))) should be
    List((1, 2), (1, 3), (1, 4), (2, 1), (3, 1), (4, 1), (2, 2), (3, 3), (4, 4))

  }

}
