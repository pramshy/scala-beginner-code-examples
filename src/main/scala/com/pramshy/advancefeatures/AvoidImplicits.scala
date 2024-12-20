package com.pramshy.advancefeatures

import java.net.URL
import scala.language.implicitConversions

object AvoidImplicits {

  object Implicits {
    implicit val myFunctionalContext: List[String => String] = List(
      x => x.toLowerCase,
      x => x.trim
    )

    implicit val myFunctionalContext2: List[String => String] = List(
      x => x.toUpperCase
    )

    implicit def stringToURL(str : String) : URL = new URL(str)

    implicit class StringToURLable(str: String) {
      def toURL : URL = new URL(str)
    }

    implicit def queryToURL(query: String) : URL = new URL(s"http://www.google.com/?q=$query")

    implicit class QueryParamToURL(str: String) {
      def toGoogleQueryURL: URL = new URL(s"http://www.google.com/?q=$str")
    }
  }
  def myImplicitParams() : Unit = {
    def _myFunction(str: String)(implicit  ctx: List[String => String]) : String = {
      ctx.foldLeft(str)((acc, func) => func(acc))
    }

    //println(_myFunction(" FooO) "))
    println("[" + _myFunction(" FooO ")(List(_.toLowerCase, _.trim)) + "]")

    import Implicits.myFunctionalContext
    println("[" + _myFunction(" Foo ") + "]")
  }

  def myFunction2() : Unit = {
    def _myFunction(obj: URL) : String = {
      obj.getHost
    }

    println(_myFunction(new URL("http://www.google.com")))

    import Implicits.stringToURL
    println(_myFunction("http://www.google.com"))

    import Implicits.StringToURLable
    println(_myFunction("http://www.google.com".toURL))
  }

  def myFunction3() : Unit = {
    def _myFunction(obj: URL): String = {
      obj.toString
    }

    println(_myFunction(new URL("http://www.google.com/?q=foo")))
    import Implicits.queryToURL
    println(_myFunction("foo"))

    import Implicits.QueryParamToURL
    println(_myFunction("foo".toGoogleQueryURL))
  }
  def main(args: Array[String]): Unit = {
    myFunction3()
  }

}
