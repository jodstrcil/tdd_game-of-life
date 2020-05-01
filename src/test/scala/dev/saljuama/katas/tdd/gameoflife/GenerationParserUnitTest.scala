package dev.saljuama.katas.tdd.gameoflife

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec

class GenerationParserUnitTest extends AnyWordSpec with Matchers {

  "The Generation Parser" when {
    val parser = new GenerationParser()

    "parsing valid inputs" must {
      val input = Seq("Generation 1", "4 8",
        "........",
        "....*...",
        "...**...",
        "........"
      )
      val generation = parser.parseGeneration(input).get

      "extract the generation number" in {
        generation.number must be(1)
      }
      "extract the dimensions of the grid" in {
        generation.rows must be(4)
        generation.columns must be(8)
      }
      "extract alive and dead cells" in {
        generation.life(1)(1) must be(false)
        generation.life(1)(4) must be(true)
      }
    }

    /* TODO: input validation
    "parsing invalid inputs" must {
      "return None" when {
        "generation is not a number" in {
          val input = Seq("Generation X", "1 1", ".")
          parser.parseGeneration(input) must be(None)
        }
        "generation is missing" in {
          val input = Seq("1 1", ".")
          parser.parseGeneration(input) must be(None)
        }
        "number of rows is not a number" in {
          val input = Seq("Generation 1", "X 1", ".")
          parser.parseGeneration(input) must be(None)
        }
        "number of columns is not a number" in {
          val input = Seq("Generation 1", "1 X", ".")
          parser.parseGeneration(input) must be(None)
        }
        "dimensions are missing" in {
          val input1 = Seq("Generation 1", "1", ".")
          val input2 = Seq("Generation 1", ".")
          parser.parseGeneration(input1) must be(None)
          parser.parseGeneration(input2) must be(None)

        }
        "grid of cells do not conform number of rows" in {
          val input = Seq("Generation 1", "1 1", ".", ".")
          parser.parseGeneration(input) must be(None)
        }
        "grid of cells do not conform number of columns" in {
          val input = Seq("Generation 1", "1 1", "..")
          parser.parseGeneration(input) must be(None)
        }
      }
    }
    */

  }
}
