package com.pramshy.scala_best_practices

import scala.language.reflectiveCalls

// Prefer Mixins Over Deep Inheritance
object MixinsOverInheritance {

  trait StringContainer {
    def string() : String
  }

  trait Countable extends StringContainer {
    def count() : Int
  }

  trait LowerCaseable extends Countable {
    def lowerCased() : String
  }

//  class MyStringContainer(val string: String) extends LowerCaseable {
//    val count: Int = string.length
//    val lowerCased : String = string.toLowerCase
//  }

  trait StringContainer2  {
    def string() : String
  }

  trait Countable2 {
    def count() : Int
  }

  trait LowerCaseable2 {
    def lowerCased() : String
  }

  class MyStringContainer2 (val string: String) extends LowerCaseable2, Countable2 {
    override def lowerCased(): String = string.toLowerCase

    override def count(): Int = string.length
  }

  class MyListContainer[A](list: List[A]) extends Countable2 {
    override def count(): Int = list.size
  }

  type Lengthed = {def length : Int}

  trait Countable3 {
    protected def value : Lengthed
    import reflect.Selectable.reflectiveSelectable
    def count : Int =  value.length
  }

  class MyLengthedContainer(val value: Lengthed)

  def myFunction4(in: Countable3 ) : Unit = {
    println(in.count)
  }

  def main(args: Array[String]): Unit = {
    // mixins
    myFunction4(new MyLengthedContainer(List(1,2,3,4,5,6)) with Countable3)
  }
}
