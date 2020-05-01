package dev.saljuama.katas.tdd.gameoflife

object Fixtures {

  def generation(number: Int, life: Seq[String]): Generation = {
    if (life.isEmpty)
      Generation(1, 0, 0, Seq(Seq()))
    else
      Generation(number, life.length, life.head.length, life.map {
        _.map {
          case '*' => true
          case _ => false
        }
      })
  }

}
