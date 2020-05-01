package dev.saljuama.katas.tdd.gameoflife

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AcceptanceTest extends AnyWordSpec with Matchers {

  "The Game of Life" must {
    val gameOfLife = new GameOfLife()

    "read a file and calculate next generation" in {
      gameOfLife.run("input.txt") must equal(
        """Generation 2
          |4 8
          |........
          |...**...
          |...**...
          |........
          |""".stripMargin)
    }
  }
}
