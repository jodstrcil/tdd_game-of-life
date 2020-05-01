package dev.saljuama.katas.tdd.gameoflife

class GenerationParser {

  def parseGeneration(input: Seq[String]): Option[Generation] = {
    if (isInvalidInput(input))
      None
    else {
      val generation = extractGenerationNumber(input.head)
      val (rows, cols) = extractDimensions(input(1))
      val life = extractGrid(input.drop(2))
      Some(Generation(generation, rows, cols, life))
    }
  }

  private def isInvalidInput(input: Seq[String]): Boolean = {

    def isGenerationLineInvalid = {
      val generationLine = input.head
      !generationLine.contains("Generation ") ||
        generationLine.split(" ").last.toIntOption.isEmpty
    }
    def isDimensionsLineInvalid = {
      val dimensionsLine = input(1)
      val dimensions = dimensionsLine.split(" ").take(2)
      dimensions.length != 2 ||
        dimensions.head.toIntOption.isEmpty ||
        dimensions.last.toIntOption.isEmpty
    }

    if (isGenerationLineInvalid) true
    else if (isDimensionsLineInvalid) true
    else false
  }

  private def extractGenerationNumber(generation: String) = {
    generation.split(" ").last.toInt
  }

  private def extractDimensions(dimensions: String) = {
    val dims = dimensions.split(" ").take(2)
    (dims.head.toInt, dims.last.toInt)
  }

  private def extractGrid(grid: Seq[String]) = {
    grid.map {
      _.map {
        case '*' => true
        case _ => false
      }
    }
  }

}
