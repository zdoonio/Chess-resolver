import game.Game
import game.board.ChessBoard
import game.pieces.{ChessPiece, Chessman}
import org.scalatest.{FlatSpec, Matchers}
import resolver.Resolver

/**
  * Created by Dominik Zduńczyk on 25.01.19.
  */
class ResolverTest extends FlatSpec with Matchers {

  "Resolver" should "initialize empty board" in {

    val board = ChessBoard(3,3)
    val king = ChessPiece(Chessman.KING)
    val resultArray: Array[Array[String]] = Array(Array(" ", " ", " "), Array(" ", " ", " "), Array(" ", " ", " "))

    Resolver.init(Game(board, List(king))).result should be (resultArray)
  }

  "Resolver" should "get all possible permutations for board 2x2 with two Rooks" in {

    val board = ChessBoard(2,2)
    val rook = ChessPiece(Chessman.ROOK)
    val game = Game(board,List(rook, rook))

    Resolver.solve(game).size should be (2)

  }

  "Resolver" should "get all possible permutations for board 3x3 with two Kings and one Rook" in {

    val board = ChessBoard(3,3)
    val rook = ChessPiece(Chessman.ROOK)
    val king = ChessPiece(Chessman.KING)
    val game = Game(board,List(rook, king, king))

    Resolver.solve(game).size should be (4)

  }

  "Resolver" should "get all possible permutations for board 4x4 with two Rooks and four Knights" in {

    val board = ChessBoard(4,4)
    val rook = ChessPiece(Chessman.ROOK)
    val knight = ChessPiece(Chessman.KNIGHT)
    val game = Game(board,List(rook, rook, knight, knight, knight, knight))

    Resolver.solve(game).size should be (8)

  }

}
