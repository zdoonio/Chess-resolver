import game.Game
import helper.Utils
import resolver.Resolver

/**
  * Created by dominik.zdunczyk on 24.01.19.
  */
object Main extends App {

  override def main(args: Array[String]): Unit = {
    println("Welcome in chess game resolver!")
    val game = Game.init
    val result = Utils.time(Resolver.solve(game))

    println(s"Number of results: ${result.length}")
    println(result.mkString("\n"))
  }
}
