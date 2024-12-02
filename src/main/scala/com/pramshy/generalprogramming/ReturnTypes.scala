package com.pramshy.generalprogramming

object ReturnTypes {

  def myFunction1(str: String) = {
    str.toLowerCase
  }

  /*def myFunction2(str: String) = {
      if(str == "FoO") {
        str.toLowerCase
      }
      else {
        str.length
      }
  }*/

  def myFunction2(str: String) : String = {
    if (str == "FoO") {
      str.toLowerCase
    }
    else {
      str.length.toString
    }
  }
  def main(args: Array[String]): Unit = {
    println(myFunction2("FoO"))
    myFunction1(myFunction2("FoO"))
  }

}
