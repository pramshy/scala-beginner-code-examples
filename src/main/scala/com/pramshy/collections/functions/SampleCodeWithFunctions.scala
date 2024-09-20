package io.pramshy.collections.functions

object SampleCodeWithFunctions extends App {

  // Problem : Create a groceries list with indexes

  private val groceries = List("Apples", "Milk", "Naan", "Eggs", "Oranges", "Almonds", "Peanut butter")
  println(groceries)

  println("---------------------------")

  println( groceries zip ( 1 to 1000) )

  private val groceriesWithIndex = groceries.zipWithIndex
    .map(t => (t._1, t._2 + 1))
    .map(_.swap)
    .map(t => s"${t._1}. ${t._2}")
    .mkString("\n")

  println("-----------------------------")
  println(groceriesWithIndex)
}
