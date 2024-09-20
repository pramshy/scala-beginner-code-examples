package io.pramshy.collections.functions

object FilterFunction extends App {
  val a = 1 to 10
  println(a.filter(_ % 2 == 0)) // evens
  println(a.filterNot(_ % 2 == 0)) // odds
  println(a.exists(_ % 2 == 0)) // is any even exists true/false

  private def filterVowels(s: String) = s.toLowerCase().filter(c => Set('a', 'e', 'i', 'o', 'u').contains(c))
  println(filterVowels("Orange"))

  private val colors = Set("Red", "Blue", "Green", "Purple", "Orange")
  println(colors.filter(a => filterVowels(a).length > 1)) // filter colors with atleast one vowel

  val map = Map(1 -> "One", 2 -> "Two", 3 -> "Three")
  println(map.filter(_._1 % 2 == 0))

  println(Some(5).filter(_ % 2 == 0)) // returns None
  println(Some(4).filter(_ % 2 == 0)) // returns Some(4)


}
