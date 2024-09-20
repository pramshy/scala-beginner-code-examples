package io.pramshy.scala_best_practices

// Prefer To Map Filter over Option rather than the pattern matching
object FilteringMappingOverOptions {

  // return true if string empty
  def myFunction(input: Option[String]) : Boolean = {
    input.exists(in => in.trim.isEmpty)
  }

  // handling None case
  def myFunction2(input: Option[String]) : Option[Int] = input match {
    case Some(in) if in.trim.nonEmpty => Some(in.length)
    case _ => None
  }

  // functional style for myFunction2
  def myFunction3(input: Option[String]): Option[Int] = { input.filter(_.nonEmpty).map(_.length) }

  // using pattern matching
  def myFunction4(input: Option[String]): Option[String] = input match {
    case Some(in) => Some(in.toLowerCase)
    case _ => None
  }

  // rewrite myFunction4 functionally.
  // preserving option identity without having to write default case for None
  def myFunction5(input: Option[String]) : Option[String] = {
    input.map(_.toLowerCase)
  }

  def main(args: Array[String]): Unit = {
    println(myFunction(Some("")))
    println(myFunction(Some("Foo")))
    println(myFunction(None))

    println(myFunction2(Some("")))
    println(myFunction2(Some("Foo")))
    println(myFunction2(None))

    println(myFunction3(Some("")))
    println(myFunction3(Some("Foo")))
    println(myFunction3(None))

    println(myFunction4(Some("Hello World!!")))
    println(myFunction5(Some("Hello World!!")))
  }
}
