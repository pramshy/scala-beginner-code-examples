package io.pramshy.scala_best_practices

object StoringFunctions {

  private val strings = List(
    "where",
    "the",
    "wild",
    "things",
    "are"
  )

  def filter(input: List[String]) : List[String] = {
    input.filterNot(_.contains("a")).filterNot(_.contains("b")).filterNot(_.length % 2 == 0)
  }

  private val filters : List[String => Boolean] = List(
    stringContainsA,
    stringContainsB,
    stringWithEvenLength
  )

  private def stringContainsA(input: String) : Boolean = input.contains("a")
  private def stringContainsB(input: String) : Boolean = input.contains("b")
  private def stringWithEvenLength(input: String) : Boolean = input.length % 2 == 0


  def filter2(input: List[String]): List[String] = {
    filters.foldLeft(input)((acc, func) => acc.filterNot(func))
  }

  def main(args: Array[String]): Unit = {
    println(filter(strings))
    println(filter2(strings))

  }
}
