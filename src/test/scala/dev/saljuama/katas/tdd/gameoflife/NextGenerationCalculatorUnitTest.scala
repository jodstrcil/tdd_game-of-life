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

      "find cells that will die because of underpopulation" when {

        "cells do not have any alive neighbours" in {
          val current = generation(1, Seq(
            "*.",
            ".."
          ))
          val expectedNext = generation(2, Seq(
            "..",
            ".."
          ))
          calculator.nextGeneration(current) must equal(expectedNext)
        }

        "cells only have one alive neighbour" in {
          val current = generation(1, Seq(
            "...",
            ".**",
            "..."
          ))
          val expectedNext = generation(2, Seq(
            "...",
            "...",
            "..."
          ))
          calculator.nextGeneration(current) must equal(expectedNext)
        }

      }

      "find cells that will stay alive" when {

        "cells have two alive neighbours" in {
          val current = generation(1, Seq(
            ".*",
            "**"
          ))
          val expectedNext = generation(2, Seq(
            ".*",
            "**"
          ))
          calculator.nextGeneration(current) must equal(expectedNext)
        }

        "cells have three alive neighbours" in {
          val current = generation(1, Seq(
            "**",
            "**"
          ))
          val expectedNext = generation(2, Seq(
            "**",
            "**"
          ))
          calculator.nextGeneration(current) must equal(expectedNext)
        }
      }

      "find cells that will die because of overcrowding" when {

        "cells have more than three alive neighbours" in {
          val current = generation(1, Seq(
            ".*.",
            "***",
            ".*."
          ))
          val expectedNext = generation(2, Seq(
            ".*.",
            "*.*",
            ".*."
          ))
          calculator.nextGeneration(current) must equal(expectedNext)
        }
      }

    }
  }
}
