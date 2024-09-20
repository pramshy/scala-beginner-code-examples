package io.pramshy

class Foo(x:Int) {
  def bar(y:Int => Int): Int = y(x)
}

object Closures extends App {
  private val m = 200
  val f = (x:Int) => x + m
  private val foo = new Foo(100)
  println(foo.bar(f))
}