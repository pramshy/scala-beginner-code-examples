package com.pramshy.generalprogramming

import java.io.FileNotFoundException
import java.nio.file.{Files, NoSuchFileException, Path}

object CatchExceptions {

  def myFunction1(filename: String): String = {
    Files.readString(Path.of(filename))
  }

  def myFunction2(filename: String): Option[String] = {
    try {
      Some(Files.readString(Path.of(filename)).mkString)
    }
    catch {
      case ex: NoSuchFileException => {
        // Log Error
        println(s"No file with name $filename found.")
        None
      }
      case _ =>  None
    }
  }
  def main(args: Array[String]): Unit = {
    println(myFunction2("hello.txt"))
  }

}
