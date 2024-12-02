package com.pramshy.concurrency

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
object FutureAreNotTheAnswer {

  private def mySimpleFuture() : Unit = {
    val str = "HellO WORlD"
    val future = Future {
      str.toLowerCase
    }

    future.foreach(println)
  }

  private def myComplicatedFuture() = {
    val txt = "HELLo WorlD"
    val future = Future {
      Thread.sleep(100)
      txt.toLowerCase
    }

    future.foreach(println)
    println("foo")
  }

  def main(args: Array[String]): Unit = {
      mySimpleFuture()
      Thread.sleep(100)
      myComplicatedFuture()
      Thread.sleep(100)
  }

}
