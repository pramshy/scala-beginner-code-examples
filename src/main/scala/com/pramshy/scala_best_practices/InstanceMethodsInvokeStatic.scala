package com.pramshy.scala_best_practices

// Instance methods invoking static methods
object InstanceMethodsInvokeStatic {

  class Foo(barVariable: Option[String]) {
    def convert(in: String) : String = in.toLowerCase
    def bar() : String = convert(barVariable.getOrElse("default"))
  }

  object Foo2 {
    def convert(in: String) : String = in.toLowerCase
  }
  class Foo2(barVariable: Option[String]) {
    def bar() : String = Foo2.convert(barVariable.getOrElse("default"))
  }

  def main(args: Array[String]): Unit = {
    println(new Foo(Some("Test")).bar())

    println(new Foo2(Some("TEST")).bar())
  }

}
