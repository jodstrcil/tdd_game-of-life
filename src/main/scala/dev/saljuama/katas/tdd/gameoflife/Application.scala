package dev.saljuama.katas.tdd.gameoflife

object Application {
  def main(args: Array[String]): Unit = {
    val gameOfLife = new GameOfLife()
    val secondGeneration = gameOfLife.run("input.txt")
    println(secondGeneration)
  }
}
