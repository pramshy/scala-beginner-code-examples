package com.pramshy.scala_best_practices

import jdk.javadoc.internal.doclets.toolkit.util.DocFinder.Input

// Do not use exceptions for validations and flow control
object FlowOfControl {

  case class Email(name: String, domain: String)

  def myFunction(input: String) : Email = {
    if(!input.contains("@")) {
      throw new IllegalArgumentException("Invalid email!");
    }
    val splitInputs = input.split("@")
    Email(splitInputs(0), splitInputs(1))
  }

  case class ValidationError (message: String)

  def isEmail_? (input: String) : Option[ValidationError] = {
    if(input.contains("@")) {
      None
    }
    else {
      Some(ValidationError("Invalid Email!"))
    }
  }

  val validators : List[String => Option[ValidationError]] = List(isEmail_?)

  def myFunction2 (input: String) : Either[List[ValidationError], Email] = {
    //validators.map(_(input)).filter(_.isDefined).map(_.get) match // complex
    validators.flatMap(_(input)) match  // simpler
      case List() =>
        val splitInputs = input.toLowerCase.split("@")
        Right(Email(splitInputs(0), splitInputs(1)))
      case list => Left(list)
  }

  def myFunction3(input: Option[String]) : Either[ValidationError, Email] = {
    input.map(str => {
      val splitIns = str.toLowerCase.split("@")
      Email(splitIns(0), splitIns(1))
    }).toRight(ValidationError("Invalid Error!!"))
  }

  def main(args: Array[String]): Unit = {
    try myFunction("foo") catch
      case e : Throwable => e.printStackTrace()
  }

}
