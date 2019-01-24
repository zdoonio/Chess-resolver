package game

/**
  * Created by dominik.zdunczyk on 24.01.19.
  */

import game.pieces.ChessPiece

/**
  * Contains solved game representation
  * @param game   game to solve object
  * @param result representation of solved chess board
  */
case class SolvedGame (
  game: Game,
  result: Array[Array[String]]
) {

  /**
    * Makes simple string from result, it helps in distinct
    * @return simple result string
    */
  def toSimpleString: String = result.map(_.mkString("")).mkString("")

  /**
    * Inserts given type of chess piece into selected place on board
    * @param row      row number
    * @param column      column number
    * @param piece  chess piece
    * @param preserveMovement if true places a dot in every spot that piece can move
    * @return true if success otherwise false
    */
  def insert(row: Int, column: Int, piece: ChessPiece, preserveMovement: Boolean = true): Boolean = {
    val noThreat = piece.allMovementOptions(row, column, game).forall { case (n, m) =>
      val field = result(n)(m)
      field == " " || field == "."
    }

    if(result(row)(column) == " " && noThreat) {
      result(row)(column) = piece.chessman.toString match {
        case "KING" => "K"
        case "QUEEN" => "Q"
        case "BISHOP" => "B"
        case "ROOK" => "R"
        case "KNIGHT" => "N"
        case _ => " "
      }

      if(preserveMovement)
        piece.allMovementOptions(row, column, game).foreach { case (n, m) =>
          setDotIfPossible(n,m)
        }

      true
    } else
      false
  }

  /**
    * Transposes game result if board is square
    * @return optional solved game with transposed result
    */
  def transposeResult: Option[SolvedGame] = if(game.board.columns == game.board.rows)
    Some(this.copy(result = result.transpose))
  else
    None

  /**
    * Rotates game result 90d clockwise if board is square
    * @return optional solved game with rotated result
    */
  def rotateResult90: Option[SolvedGame] = this.transposeResult.map { transposed =>
    transposed.copy(result = transposed.result.map(_.reverse))
  }

  /**
    * Rotates game result 90d counterclockwise if board is square
    * @return optional solved game with rotated result
    */
  def rotateResult90Counterclockwise: Option[SolvedGame] = this.transposeResult.map { transposed =>
    transposed.copy(result = transposed.result.reverse)
  }

  /**
    * Rotates game result 180d
    * @return solved game with rotated result
    */
  def rotateResult180: SolvedGame = this.copy(result = result.reverse.map(_.reverse))

  /**
    * Sets dot in solved game array if possible
    * @param n row number
    * @param m column number
    */
  private def setDotIfPossible(n: Int, m: Int): Unit = {
    if(n >= 0 && m >= 0 && n < result.length && m < result(n).length && result(n)(m) == " ")
      result(n)(m) = "."
  }

  /**
    * Prints out solved game
    * @return string with solved game visual representation
    */
  override def toString: String = boardColumnDescription +
    result.zipWithIndex.map { case (resultRow, i) =>
      resultRow.mkString(String.format("%5s", i + 1 + "| "), " | ", " |\n")
    }.mkString(boardSeparator, boardSeparator, boardSeparator)

  /**
    * Adds column description to board visual representation
    * @return string with column descriptors
    */
  private def boardColumnDescription: String = (1 to game.board.columns).map { i =>
    String.format("%3s", intToBase26String(i))
  }.mkString("   |", "|", "|\n").replaceAll("`", " ")

  /**
    * Transforms an integer to string counting eg. a, b...z, aa, ab...zzz.
    * @param int integer number to transform
    * @return string counting
    */
  private def intToBase26String(int: Int): String = {
    var number = int
    var result = ""
    val offset = 97
    val noOfChars = 26

    while (number > 0) {
      number = number - 1
      result = (number % noOfChars + offset).asInstanceOf[Char] + result
      number = (number - (number % noOfChars)) / noOfChars
    }
    result
  }

  /**
    * Adds separation line to board
    * @return string with separation line
    */
  private def boardSeparator: String = s"---${"+---" * game.board.columns}+\n"
}

object SolvedGame {

  /**
    * Initializes solved game with empty cells
    *
    * @param game game to solve object
    * @return empty object of SolvedGame
    */
  def init(game: Game): SolvedGame = SolvedGame (game,
    (0 until game.board.rows).toArray.map { n =>
      (0 until game.board.columns).toArray.map { m =>
        " "
      }
    }
  )
}
