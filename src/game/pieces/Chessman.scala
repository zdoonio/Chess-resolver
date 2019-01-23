package game.pieces

/**
  * Created by dominik.zdunczyk on 23.01.19.
  */
object Chessman extends Enumeration {
  type Chessman = Value

  val KING, QUEEN, BISHOP, ROOK, KNIGHT = Value
}
