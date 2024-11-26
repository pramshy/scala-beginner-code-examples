package com.pramshy.concurrency

import akka.actor.AbstractActor.Receive
import akka.actor.{Actor, ActorSystem, Props, ActorRef}

import scala.concurrent.duration.*
import akka.pattern.ask
import akka.util.Timeout
object BlockingIO {

  class Test1 extends Actor {
    def receive : Receive = {
      case str : String => {
        Thread.sleep(1000)
        sender() ! str.toLowerCase
      }
    }
  }

  def blockingOnMainThreadPool() : Unit = {
    val system = ActorSystem("Test-Actors")
    val actor1 = system.actorOf(Props[Test1]())
    implicit val timeout: Timeout = Timeout(5.second)
    import system.dispatcher
    (actor1 ? "FOo").foreach(println)
    (actor1 ? "BaR").foreach(println)
  }

  class Upstream(downstream: ActorRef) extends Actor {
    def receive : Receive = {
      case str : String => {
        Thread.sleep(1000)
        downstream ! str.toLowerCase
      }
    }
  }

  class Downstream extends Actor {
    def receive : Receive = {
      case str : String => println(str)
    }
  }

  def blockingOnMainThreadPool2() : Unit = {
    val system = ActorSystem("Test-Actors")
    val ds = system.actorOf(Props[Downstream]())
    val us = system.actorOf(Props.create(classOf[Upstream], ds))

    us ! "FoO"
    us ! "BaR"
  }

  class Upstream2(processor: ActorRef, downstream: ActorRef) extends Actor {
    def receive : Receive = {
      case str: String =>
        println("Got Message")
        import this.context.dispatcher
        implicit val timeout: Timeout = Timeout(5.second)
        (processor ? str).foreach(downstream ? _)
    }
  }

  class Processor extends Actor {
    def receive : Receive = {
      case str : String =>
        Thread.sleep(1000)
        sender() ! str.toLowerCase
    }
  }

  def blockingOnMainThreadPool3(): Unit = {
    val system1 = ActorSystem("System-1")
    val system2 = ActorSystem("System-2")
    val processor = system2.actorOf(Props[Downstream]())
    val ds = system1.actorOf(Props[Downstream]())
    val us = system1.actorOf(Props.create(classOf[Upstream2], processor, ds))

    us ! "FoO"
    us ! "BaR"
  }
  def main(args: Array[String]): Unit = {
    blockingOnMainThreadPool2()
  }

}
