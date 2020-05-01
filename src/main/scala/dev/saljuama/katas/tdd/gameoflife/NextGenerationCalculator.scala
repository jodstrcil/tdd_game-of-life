package dev.saljuama.katas.tdd.gameoflife

class NextGenerationCalculator {

  def nextGeneration(generation: Generation): Generation = {
    val nextLife =
      for (row <- 0 until generation.rows)
        yield for (col <- 0 until generation.columns)
          yield cellStateInNextGeneration(row, col, generation)
    Generation(generation.number + 1, generation.rows, generation.columns, nextLife)
  }

  private def cellStateInNextGeneration(row: Int, col: Int, currentGeneration: Generation) = {
    val aliveNeighbours = (for (
      r <- row - 1 to row + 1 if r >= 0 && r < currentGeneration.rows;
      c <- col - 1 to col + 1 if c >= 0 && c < currentGeneration.columns
    ) yield (r, c))
      .filterNot(_ == (row, col))
      .map { n => currentGeneration.life(n._1)(n._2) }
      .count(_ == true)

    val currentState = currentGeneration.life(row)(col)
    if (!currentState && aliveNeighbours == 3) true
    else if (aliveNeighbours == 2 || aliveNeighbours == 3) currentState
    else false
  }
}
