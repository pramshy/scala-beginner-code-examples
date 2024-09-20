package io.pramshy.scala_best_practices

object PatternMatchingAllStatements {

  // Overuse of pattern matching instead use if else
  def myFunction(input: Int) : Boolean = input match {
    case 0 => true
    case _ => false
  }

  private def myFunction2(input: String) : Boolean = input match {
    case "foo"|"" => true
    case _ => false
  }

  def main(args: Array[String]): Unit = {
    println(myFunction(10))
    println(myFunction2("foo"))
  }

}
