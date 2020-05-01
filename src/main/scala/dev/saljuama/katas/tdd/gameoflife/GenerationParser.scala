package dev.saljuama.katas.tdd.gameoflife

case class Generation(number: Int, rows: Int, columns: Int, life: Seq[Seq[Boolean]])

class GenerationParser() {

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
    //TODO: input validation
    false
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
