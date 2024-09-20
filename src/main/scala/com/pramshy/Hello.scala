package io.pramshy

case class Hello(content: String) {
  def print(): Unit =  {
    println(content)
  }
}

object MainObject extends App {
  private val hello = Hello("Hello!!")
  hello.print()
}
