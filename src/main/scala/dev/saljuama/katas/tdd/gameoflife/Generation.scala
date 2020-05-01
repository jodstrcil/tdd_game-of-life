package dev.saljuama.katas.tdd.gameoflife

case class Generation(number: Int, rows: Int, columns: Int, life: Seq[Seq[Boolean]]) {

  override def toString: String = {
    def printCells: String = {
      life.map { line =>
        line.map {
          case true => '*'
          case false => '.'
        }.mkString("")
      }.mkString("\n")
    }

    s"""Generation $number
       |$rows $columns
       |$printCells
       |""".stripMargin
  }

}
