package resolver

import game.Game

/**
  * Created by dominik.zdunczyk on 23.01.19.
  */
object Resolver extends App {

  override def main(args: Array[String]) = {
    println("Welcome in chess game resolver!")
    Game.init
  }

}
