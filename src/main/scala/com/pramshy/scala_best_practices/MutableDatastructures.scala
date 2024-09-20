package io.pramshy.scala_best_practices

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object MutableDatastructures {

  private val mutableMap = new mutable.LinkedHashMap[Int, String]()

  private def myMutableMap() : Unit = {
    mutableMap.put(1, "Foo")
    mutableMap.put(2, "Bar")
    mutableMap.put(3, "Baz")
  }

  private def myMutableMap2(): Unit = {
    mutableMap.remove(2)
  }

  val mutableList = new mutable.ListBuffer[String]()

  def myMutableArray() : Unit = {
    mutableList.append("Foo")
    mutableList.append("Bar")
    mutableList.append("Baz")
  }

  def muMutableArray2() : Unit = {
    mutableList.remove(mutableList.indexOf("Bar"))
  }

  def main(args: Array[String]): Unit = {
    println(mutableMap)
    myMutableMap()
    println(mutableMap)
    myMutableMap2()
    println(mutableMap)
    myMutableArray()
    println(mutableList)
    myMutableMap2()
    println(mutableList)
  }

}
