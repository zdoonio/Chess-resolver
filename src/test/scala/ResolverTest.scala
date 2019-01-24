import game.Game
import game.board.ChessBoard
import game.pieces.{ChessPiece, Chessman}
import org.scalatest.{FlatSpec, Matchers}
import resolver.Resolver

/**
  * Created by Dominik Zduńczyk on 25.01.19.
  */
class ResolverTest extends FlatSpec with Matchers {

  "Rook" should "get all possible permutations for board 2x2 with two Rooks" in {

    val board = ChessBoard(2,2)
    val rook = ChessPiece(Chessman.ROOK)
    val game = Game(board,List(rook, rook))

    Resolver.solve(game).size should be (2)

  }

}
