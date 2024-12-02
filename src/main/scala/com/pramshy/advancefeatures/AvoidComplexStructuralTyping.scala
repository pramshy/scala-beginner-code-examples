package com.pramshy.advancefeatures

import reflect.Selectable.reflectiveSelectable
object AvoidComplexStructuralTyping {

  class Foo(val foo : String) {
    def bar() : String = foo
  }

  def myFunction(input:  { def bar(): String }): String = {
    input.bar().toLowerCase
  }

  def myFunction2(input: {def foo: String}): String = {
    input.foo.toLowerCase
  }

  def myFunction3(input: {def bar(): String; def foo: String}): String = {
    input.foo.equals(input.bar()).toString
  }

  type FooType = {def bar(): String; def foo: String}

  def myFunction4(input: FooType): String = {
    input.foo.equals(input.bar()).toString
  }

  trait FooTrait {
    def bar(): String
    def foo: String
  }

  def myFunction5(input: FooTrait): String = {
    input.foo.equals(input.bar()).toString
  }
  def main(args: Array[String]): Unit = {
    println(myFunction2(new Foo("FoO")))
    println(myFunction3(new Foo("FoO")))
    println(myFunction4(new Foo("FoO")))
    println(myFunction5(new Foo("FoO") with FooTrait))
  }

}
