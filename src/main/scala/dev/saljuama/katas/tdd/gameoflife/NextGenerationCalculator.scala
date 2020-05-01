package dev.saljuama.katas.tdd.gameoflife

class NextGenerationCalculator {

  def nextGeneration(generation: Generation): Generation = {
    Generation(generation.number+1, generation.rows, generation.columns, generation.life)
  }

}
