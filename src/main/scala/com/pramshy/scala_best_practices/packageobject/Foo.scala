package com.pramshy.scala_best_practices.packageobject

trait Foo[A] {
  def bar : A
}
case class Foo1Impl(bar : String) extends StringedFoo
case class Foo2Impl(bar: Int) extends IntFoo
case class Foo3Impl(bar: Long) extends LongFoo

