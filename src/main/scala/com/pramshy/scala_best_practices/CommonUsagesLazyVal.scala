package io.pramshy.scala_best_practices

import scala.io
// Common Usages of lazy vals
object CommonUsagesLazyVal {

  case class Foo(input: List[String]) {
    val lengths = {
      Thread.sleep(1000)
      input.map(_.length)
    }

    lazy val lowered = {
      Thread.sleep(1000)
      input.map(_.toLowerCase)
    }
  }

  def myFunction(foo: Foo): Unit = {
    println(foo.lengths)
    separator()
    println(foo.lowered)
  }

  lazy val fileContents = {
    val f = io.Source.fromURL(ClassLoader.getSystemResource("foo.txt"))
    f.getLines().mkString("\n")
  }

  def main(args: Array[String]): Unit = {
    separator()
    myFunction(Foo(List("Foo", "Bar", "Sha", "Baz")))
    separator()
    println(fileContents)
    separator()
  }

  def separator() : Unit = {
    for(i <- 1 until 10) print("_")
    println()
  }
}
