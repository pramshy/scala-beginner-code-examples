package io.pramshy.scala_best_practices


// Prefer value matches over guards
object ValueMatchesOverGuards {

  case class Foo( field1 : Int, field2: String)

  // Using guards
  def myFunction(input: Foo) : Boolean = input match {
    case Foo(f1, f2) if f1 == 0 && f2 == "" => true
    case _ => false
  }

  // Using value matches
  def myFunction2(input: Foo): Boolean = input match {
    case Foo(0, "") => true
    case _ => false
  }

  // case for using guards over value match
  def myFunction3(input: Foo): Boolean = input match {
    case Foo(0, f2) if f2.trim.isEmpty => true
    case _ => false
  }

  def myFunction4(input: Foo): Boolean = input match {
    case Foo(0|2, "") => true
    case _ => false
  }

  // avoid long and complex value matches
  def myFunction5(input: Foo): Boolean = input match {
    case Foo(0, ""|"undefined"|"null"|"blank") => true
    case _ => false
  }

  // re-writing myFunction5 with using guards instead of long value match
  val emptyStrings = List("", "undefined", "null", "blank")
  def myFunction6(input: Foo): Boolean = input match {
    case Foo(0, f2)  if emptyStrings.contains(f2) => true
    case _ => false
  }

  def main(args: Array[String]): Unit = {
    println(myFunction(Foo(0, "")))
    println(myFunction2(Foo(0, "")))
    println(myFunction3(Foo(0, "        ")))
    println(myFunction4(Foo(2, "")))
    println(myFunction5(Foo(0, "undefined")))
    println(myFunction6(Foo(0, "undefined")))
  }

}
