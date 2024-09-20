package io.pramshy.collections.functions

object ForEachFunction extends App {

  // Some fun with map
  val a = 1 to 10
  println(a.map(x => println(x))) // println returns Unit type

  a.foreach(x => println(x))
  a.foreach(println(_))
  a.foreach(println _) //
  a.foreach(println)
  a foreach println // as single parameter

}
