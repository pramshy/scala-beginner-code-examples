package com.pramshy.scala_best_practices

// Useless Traits
object UselessTraits {

  trait Foo {
    def execute(input: String) : String
  }

  // misfit use of Trait foo and can be replaced with function
  def myFunction(foo: Foo) : String = {
    foo.execute("Blah")
  }

  // replaced foo trait with anonymous function
  def myFunction2(foo: String => String) : String = {
    foo("Blah")
  }


  trait Foo2 {
    def foo() : String
    def bar() : String
  }

  class Foo2Impl(fooVal: String, barVal: String) extends Foo2 {

    override def foo(): String = fooVal

    override def bar(): String = barVal
  }

  // Foo2 trait can be replaced with simple class as there is only one implementation for trait
  def myFunction3(foo: Foo2) : String = {
    foo.foo() + ":" + foo.bar()
  }

  // replaced Foo2 trait with a class Foo3
  class Foo3(fooValue: String, barValue: String)  {
    def foo() : String = fooValue
    def bar() : String = barValue
  }

  def myFunction4(foo: Foo3) : String = {
    foo.foo() + ":" + foo.bar()
  }

  def main(args: Array[String]): Unit = {
    println(myFunction(new Foo() {
      override def execute(input: String): String = input.toLowerCase
    }))

    println(myFunction2(_.toLowerCase))

    println(myFunction3(new Foo2Impl("My Foo", "My Bar")))

    println(myFunction4(new Foo3("My Foo", "My Bar")))
  }

}
