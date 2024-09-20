package io.pramshy.scala_best_practices

// prefer pattern matching to type casting
object PatternMatchingOverTypeCasting {

  // typecasting in scala
  def myFunction (input: Any) : String = {
    input.asInstanceOf[String]
  }

  def myFunction2(input: Any) : Option[String] = {
    if( input.isInstanceOf[String] ) {
      Some(input.asInstanceOf[String])
    }
    else {
      None
    }
  }

  def myFunction3(input: Any) : Option[String] = input match {
    case in : String => Some(in)
    case _ => None
  }

  def main(args: Array[String]): Unit = {

    println("------------ Function1 -------------")
    println(myFunction("Foo"))
    try {
      println(myFunction(2))
    }
    catch {
      case e : Throwable => e.printStackTrace()
    }

    println("------------Function2 --------------")
    println(myFunction2("Hello"))
    println(myFunction2(2))

    println("------------Function3 --------------")
    println(myFunction3("Foo"))
    println(myFunction3(2))
  }


}
