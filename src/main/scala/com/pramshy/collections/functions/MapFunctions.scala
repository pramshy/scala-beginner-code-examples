package io.pramshy.collections.functions

object MapFunctions extends App {
  val a = List(1, 2, 3, 4, 5, 6)
  val f = (x:Int) => x + 1

  println(a.map(f))
  println(a.map((x:Int) => x +1))
  println(a.map(x => x +1))
  println(a.map( _ + 1))
  println(a.map(1 + _))
  import scala.language.postfixOps
  println(a.map(1+))

  val b = Set("Brown", "Red", "Green", "Purple", "Gray", "Yellow")
  println(b.map(x => x.length)) // duplicate ignored as set
  println(b.map(_.length)) // duplicate ignored
  println(b.map(x => (x, x.length)))

  private val fifaMenChamps = Map(Symbol("Germany") -> 4, Symbol("Brazil") -> 5, Symbol("Italy") -> 4, Symbol("Argentina") -> 2)
  println(fifaMenChamps.map(t => (Symbol("Team " + t._1.name), t._2)))

  // map can be used on strings
  println("Hello!".map(c => (c + 1).toChar))

  // map can be used on Option Some None
  println(Some(4).map(1+))
  println(None.asInstanceOf[Option[Int]].map(1+))

  val age:Option[Int] = None
  println(age.map(1+))

}
