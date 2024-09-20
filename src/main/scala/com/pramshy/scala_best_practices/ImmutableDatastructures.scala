package io.pramshy.scala_best_practices

import scala.annotation.tailrec

object ImmutableDatastructures {

  private def myFunction(input: String, count: Int) : List[String] = {
    @tailrec
    def _myFunction(remaining: Int, out: List[String]) : List[String] = {
      if(remaining == 0) {
        out
      }
      else {
        _myFunction(remaining - 1, s"$remaining: $input" :: out)
      }
    }
    _myFunction(count, List())
  }

  def main(args: Array[String]): Unit = {
    println(myFunction("foo", 10))
  }

}
