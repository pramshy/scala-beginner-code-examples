package io.pramshy.collections.functions

object MoreFunctions extends App {

  // Partition
  val result1 = List(1,2,3,4,5,6).partition(x => x % 2 != 0)
  println(s"result1 = $result1")

  // GroupBy
  val result2 = List("Red", "Orange", "Green", "Grey", "Purple", "Pink")
            .groupBy(x => x.head)
  println(s"result2 = $result2")

  // take
  val result3 = (1 to 100).take(10)
  println(s"result3 = $result3")

  // takeRight
  val result4 = (1 to 100).takeRight(10)
  println(s"result4 = $result4")

  // takeWhile
  val result5 = (1 to 100).takeWhile(x => x < 40)
  println(s"result5 = $result5")

  // distinct
  val result6 = List(1,2,3,4,4,3,2,1).distinct
  println(s"result6 = $result6")

  val result7 = List.empty[Int]
  println(s"result7 = $result7")

  val result8 = List.fill(10){
    val x = 10
    val y = 20
    x + y + 19
  }
  println(s"result8 =  $result8")


}
