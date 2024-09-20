package com.pramshy.scala_best_practices

object NoReturnKeyword {

  def myFunction(in : String) : String = {
    val out = in.split("@")
    return out(0).toLowerCase
  }

  def myFunction2(in: String) : String = in.split("@")(0).toLowerCase

  def myFunction3(in: Option[String]) : Option[String] = {
    if(in.isEmpty) {return None}
    Some(in.get.split("@")(0).toLowerCase)
  }

  def myFunction4(in: Option[String]): Option[String] = {
    in.map(_.split("@")(0).toLowerCase)
  }

  def myFunction5(in: Option[String]): Option[String] = if(in.isEmpty) {
    None
  }
  else {
    Some(in.get.split("@")(0).toLowerCase)
  }

  def main(args: Array[String]): Unit = {
    println(myFunction("foo@bar.com"))
    println(myFunction2("foo@bar.com"))
    println(myFunction3(Some("foo@bar.com")))
    println(myFunction4(Some("foo@bar.com")))
  }

}
