package com.pramshy.advancefeatures

import scala.language.postfixOps

object AvoidPostfixNotations {

  def myFunction() : Unit = {
    var length = 0
    val names = List("foo", "bar", "sha", "baz")
    names toList;
    length = names.length
  }

  def myFunction2(): Unit = {
    val name = List("foof", "bar", "sha", "baz")

    name.map {_.toLowerCase}.filter {_.length > 2}
    //or
    name map {_.toLowerCase} filter {_.length > 2}
    //or
    name.map(_.toLowerCase).filter(_.length > 2)
  }

  def main(args: Array[String]): Unit = {
    myFunction2()
  }

}
