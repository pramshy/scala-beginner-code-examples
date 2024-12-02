package com.pramshy.generalprogramming

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Input

object NamingConventions {

  def process(str: String) : String = {
    str.toLowerCase
  }

  /*def convertStringToLower(str: String) : String = {
    str.toLowerCase
  }*/

  def convertStringToLower(input: String): String = {
    input.toLowerCase
  }

  def uppercaseCSVWithLength(input: String, length: Int): String = {
    input.split(",").map(str => if (str.length == 2) str.toUpperCase else str).mkString(",")
  }
  def main(args: Array[String]): Unit = {
    println(uppercaseCSVWithLength("sha,bo,kim,jj", 2))
  }

}
