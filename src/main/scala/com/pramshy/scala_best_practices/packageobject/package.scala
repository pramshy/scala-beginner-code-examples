package com.pramshy.scala_best_practices

// Avoid using other code or class in package object
// No classes inside a package object
package object packageobject {

  // Avoid in package object. Its should be in its own class Foo
  /*trait Foo
  case class Foo1Impl(bar : String) extends Foo
  case class Foo2Impl(bar: Int) extends Foo
  case class Foo3Impl(bar: Long) extends Foo*/

  // types for package .. Fit in package object
  type StringedFoo = Foo[String]
  type LongFoo = Foo[Long]
  type IntFoo = Foo[Int]

}
