package dev.saljuama.katas.tdd.gameoflife

class NextGenerationCalculator {

  def nextGeneration(generation: Generation): Generation = {
    val nextLife: Seq[Seq[Boolean]] = for (row <- 0 until generation.rows) yield for (col <- 0 until generation.columns)
      yield cellStateInNextGeneration(row, col, generation)
    Generation(generation.number + 1, generation.rows, generation.columns, nextLife)
  }

  private def cellStateInNextGeneration(row: Int, col: Int, currentGeneration: Generation) = {
    val neighbourCells: Seq[(Int, Int)] = {
      (for (
        r <- row - 1 to row + 1 if r >= 0 && r < currentGeneration.rows;
        c <- col - 1 to col + 1 if c >= 0 && c < currentGeneration.columns
      ) yield (r, c))
        .filter { _ != (row, col) }
    }
    val aliveNeighbours: Int = neighbourCells
      .map { cell => currentGeneration.life(cell._1)(cell._2) }
      .count(alive => alive)
    val cellCurrentState = currentGeneration.life(row)(col)

    if (!cellCurrentState  && aliveNeighbours == 3) true
    else if (aliveNeighbours == 2 || aliveNeighbours == 3) cellCurrentState
    else false
  }

}
