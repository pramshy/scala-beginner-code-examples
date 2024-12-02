package com.pramshy.concurrency

import akka.actor.{Actor, ActorSystem, Props}


import java.util.concurrent.{LinkedBlockingQueue, ThreadPoolExecutor, TimeUnit}
import akka.util.Timeout
import scala.concurrent.duration._
import akka.pattern.ask

object AskOverInternalMethod {

  def internalMethod() : Unit = {
    val message = "Hello WorlD"
    val tpe = new ThreadPoolExecutor(1, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue[Runnable]())
    val runnable: Runnable = new Runnable {
      var result: String = ""
      override def run(): Unit = {
        Thread.sleep(1000)
        this.result = message.toLowerCase
      }
    }
    val r = tpe.submit(runnable)
    val r2 = r.get(2, TimeUnit.SECONDS)
    println(s"[${r2}]")
  }

  class Test1 extends Actor {
    def receive = {
      case in : String => {
        Thread.sleep(1000)
        sender() ! in.toLowerCase
      }
    }
  }

  def askMethod() : Unit = {
    val system = ActorSystem("Test-System")
    val t1 = system.actorOf(Props[Test1]())
    import system.dispatcher
    implicit val timeout: Timeout = Timeout(2.second)
    (t1 ? "HellO WOrlD").foreach(println)
  }
  def main(args: Array[String]): Unit = { 
    //internalMethod()
    askMethod()
  }

}
