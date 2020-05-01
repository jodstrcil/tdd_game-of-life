package dev.saljuama.katas.tdd.gameoflife

import dev.saljuama.katas.tdd.gameoflife.Fixtures.generation
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class NextGenerationCalculatorUnitTest extends AnyWordSpec with Matchers {

  "The Next Generation Calculator" when {
    val calculator = new NextGenerationCalculator()

    "calculating the next generation" must {

      "increment the generation number" in {
        val current = generation(1, Seq())
        val next = calculator.nextGeneration(current)
        next.number must be(2)
      }

    }
  }
}
