import game.{Game, SolvedGame}
import game.board.ChessBoard
import game.pieces.{ChessPiece, Chessman}
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by dominik.zdunczyk on 25.01.19.
  */
class SolvedGameTest extends FlatSpec with Matchers {

  "SolvedGame" should "rotate board by 90 degrees" in {

    val board = ChessBoard(3,3)
    val rook = ChessPiece(Chessman.ROOK)
    val king = ChessPiece(Chessman.KING)
    val game = Game(board,List(rook, king, king))
    val resultArray = Array(Array(" ", "R", " "), Array(".", ".", "."), Array("K", ".", "K"))
    val transposedArray = Array(Array("K", ".", " "), Array(".", ".", "R"), Array("K", ".", " "))

    SolvedGame(game, resultArray).rotateResult90.get.result should be (transposedArray)

  }

  "SolvedGame" should "rotate board by 90 degrees clockwise" in {

    val board = ChessBoard(3,3)
    val rook = ChessPiece(Chessman.ROOK)
    val king = ChessPiece(Chessman.KING)
    val game = Game(board,List(rook, king, king))
    val resultArray = Array(Array(" ", "R", " "), Array(".", ".", "."), Array("K", ".", "K"))
    val transposedArray = Array(Array(" ", ".", "K"), Array("R", ".", "."), Array(" ", ".", "K"))

    SolvedGame(game, resultArray).rotateResult90Counterclockwise.get.result should be (transposedArray)

  }

}
