package com.pramshy.concurrency

import akka.actor.AbstractActor.Receive
import akka.actor.{Actor, ActorRef, ActorSystem, Props}

import java.util.concurrent.atomic.AtomicInteger

object SingleProducer {

  private val actorSystem = ActorSystem("Test-System")

  private class StringPersister extends Actor {
    def receive : Receive = {
      case str : String => println(str)
    }
  }

  private var persister: ActorRef = actorSystem.actorOf(Props[StringPersister]())

  val list = List("foo", "bar", "sha", "baz")

//  class StringToUpperProducer extends Actor {
//    def receive : Receive= {
//      case Symbol("Go") => list.foreach(persister ! _.toUpperCase)
//    }
//  }

object StringToUpperProducer {
  val index = new AtomicInteger(0)
}

class StringToUpperProducer extends Actor  {
    def receive : Receive = {
      case Symbol("Go") => {
        var index = StringToUpperProducer.index.getAndIncrement()
        while(index < list.length) {
          persister ! list(index).toUpperCase
          index = StringToUpperProducer.index.getAndIncrement()
        }
      }
    }
  }

  def multiProducers(): Unit = {
    val toUpperProducer1 = actorSystem.actorOf(Props[StringToUpperProducer]())
    val toUpperProducer2 = actorSystem.actorOf(Props[StringToUpperProducer]())

    toUpperProducer1 ! Symbol("Go")
    toUpperProducer2 ! Symbol("Go")
  }
  def main(args: Array[String]): Unit = {
    multiProducers()
  }
}
