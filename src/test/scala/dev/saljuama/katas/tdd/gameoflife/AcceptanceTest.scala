package dev.saljuama.katas.tdd.gameoflife

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class AcceptanceTest extends AnyWordSpec with Matchers {

  "The Game of Life" must {
    import scala.io.Source
    val input : Seq[String] = Source.fromResource("input.txt").getLines.toSeq
    val parser = new GenerationParser()
    val calculator = new NextGenerationCalculator()

    "read a file and calculate next generation" in {
      val initialGeneration = parser.parseGeneration(input).get
      val result = calculator.nextGeneration(initialGeneration)
      result.toString must equal(
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
