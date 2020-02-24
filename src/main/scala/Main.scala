import game.Game
import helper.Utils
import resolver.Resolver

/**
  * Created by dominik.zdunczyk on 24.01.19.
  */
object Main extends App {
  println("Welcome in chess game resolver!")
  val game = Game.init
  val result = Utils.time(Resolver.solve(game))

  println(result.mkString("\n"))
  println(s"Number of results: ${result.length}")

}
