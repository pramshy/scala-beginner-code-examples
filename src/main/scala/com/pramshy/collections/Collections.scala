package io.pramshy.collections

object Lists extends App {
  // companion object class apply method call is hidden
  val a = List(1, 2, 3, 4, 5, 6)

  val a2 = List.apply(1, 2, 3, 4, 5, 6)

  // right associative method Nil.::(5). Nil is empty List
  val a3 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

  println(a.head) // 1
  println(a.tail) // 2, 3, 4, 5, 6
  println(a.init) // 1, 2, 3, 4, 5
  println(a.last) // 5

  println(a.apply(3)) //4
  println(a.min)
  println(a.max)
  println(a.isEmpty)
  println(a.nonEmpty)
  println(a.updated(3, 100)) // underused

  println(a.mkString("[","***","]"))

}

object Sets extends App{
  private val set = Set.apply(1, 2, 3, 4, 5)
  private val set2 = Set(1, 2, 3, 4, 5)
  private val set3 = Set(1, 2, 3, 4, 5, 6)
  private val set4 = Set(1, 2, 3, 4, 5, 6, 6, 7)

  println(set)
  println(set2)
  println(set3)
  println(set4)

  private val set5 = Set(1, 2)
  println(set diff set4)
  println(set4 diff set)
  println(set union set3)
  println(set intersect set3)
  println(set5 intersect set4)

  println(set ++ set2)
  println( set ++ List(15, 19, 20))
  println(set -- set5)
  println(set -- Set(3, 4, 5))
  println(set - 3)

  println(set.apply(4)) // contains
 }

object Maps extends  App {
  private val m = Map.apply((1, "One"), (2, "Two"), (3, "Three"))
  private val m2 = Map((1, "One"), (2, "Two"), (3, "Three"))

  // Creates a tuple2
  private val t:(Int, String) = 3 -> "Three"

  private val m3 = Map(1 -> "One", 2 -> "Two", 3 -> "Three")

  println(m.get(1)) // Some("One") Some is equivalent to Optional in java
  println(m.apply(1)) // "One"
  println(m(1)) // "One"
  println(m.get(4)) // None
  // println(m(4)) // Error

  println(m3.toList)
  println(m3.keys) // Set
  println(m3.keySet) //Set
  println(m3.values.toSet)

  private val s = new String("Co")
  private val s2 = "Co"
  println(s == s2) // true
  println(s eq s2) // false

  private val co = Symbol("Co")
  import language.deprecated.symbolLiterals
  val co2 = 'Co
  println(co == co2) // true
  println(co eq co2) // true
}

object Arrays extends App {
  val a:Array[Int] = Array(1, 2, 3, 4, 5)
  println(a.head)
  println(a.tail.mkString(","))
  println(a.init.mkString(","))
  println(a.last)
  println(a.max)
  println(a.isEmpty)
  println(a.nonEmpty)

  private def repeatedParameterMethod(x:Int, y:String, z:Any*) = {
    println(z)
    "%d %ss give you %s".format(x, y, z.mkString(", "))
  }

  println(repeatedParameterMethod(3, "eggs", "a delicious sandwich", "protein", "high cholesterol"))
  println(repeatedParameterMethod(3, "eggs", List("a delicious sandwich", "protein", "high cholesterol"):_*))
}

object Ranges extends App {
  var r = 1 to 10 //include 10
  var r2 = 1 until 10 //exclude 10
  println(r)
  println(r2)
  println(r2.head)
  println(r2.tail)

  val r3 = 2 to 10 by 2
  val r4 = 10 to 2 by -2
  val r5 = ('a' to 'z') ++ ('A' to 'Z') // return Vector

  val r6 = Range(1, 10)
  val r7 = Range(1, 10 , 2)
  val r8 = Range.inclusive(1, 10)
  val r9 = Range.inclusive(2, 10, 2)

  for(i <- 2 to 10 by 2) println(i + 1)
}