package com.pramshy.concurrency

import akka.actor.{Actor, ActorSystem, Props}
import akka.util.Timeout
import scala.concurrent.duration._
import akka.pattern.ask

object ActorsOnlyReceiveData {

  case class Message(str: String, cb: (String => Unit)) {}

  class Test1 extends Actor {
    def receive = {
      case Message(str, cb) => {
        println(s"${Thread.currentThread().getName} Start")
        Thread.sleep(1000)
        println(s"${Thread.currentThread().getName} calling cb")
        cb(str.toLowerCase)
      }
    }
  }

  def sendingMethod() : Unit = {
    val system = ActorSystem("Test-System")
    val t1 = system.actorOf(Props[Test1]())
    println(s"${Thread.currentThread().getName} Sending message")
    t1 ! Message("HellO WOrlD", str => {
      Thread.sleep(1000)
      println(s"${Thread.currentThread().getName} ${str}")
    })
    println(s"${Thread.currentThread().getName} Done")
  }

  class Test2 extends Actor {
    def receive = {
      case str : String => {
        println(s"${Thread.currentThread().getName} Start")
        Thread.sleep(1000)
        println(s"${Thread.currentThread().getName} Done")
        sender() ! str.toLowerCase
      }
    }
  }

  def asking() : Unit = {
    val system = ActorSystem("Test-System")
    val t2 = system.actorOf(Props[Test2]())
    import  system.dispatcher
    implicit val timeout: Timeout = Timeout(2.second)
    (t2 ? "HeLLo WorLD").foreach(msg => {
      println(s"${Thread.currentThread().getName} ${msg}")
    })
  }
  def main(args: Array[String]): Unit = {
    asking()
  }

}
