package io.pramshy

object Functions extends App {
  private var f1: Function1[Int, Int] = new Function1[Int, Int] {
    override def apply(x: Int): Int = x + 1
  }

  f1 = x => x + 1

  println(f1.apply(4))
  println(f1(4))

  val f0: Function0[Int] = new Function0[Int]:
    override def apply(): Int = 1

  println(f0())

  val fun1: String => (String, Int) = (x: String) =>  (x, x.length)
  println(fun1("Hello"))

}
