package dev.saljuama.katas.tdd.gameoflife

import scala.io.Source

class GameOfLife {

  private val parser = new GenerationParser()
  private val calculator = new NextGenerationCalculator()

  def run(fileName: String): String = {
    parser
      .parseGeneration(parseInputFile(fileName))
      .map(calculator.nextGeneration)
      .map(_.toString)
      .getOrElse("Invalid Input file")
  }

  private def parseInputFile(fileName: String): Seq[String] =
    Source.fromResource(fileName).getLines.toSeq
}
