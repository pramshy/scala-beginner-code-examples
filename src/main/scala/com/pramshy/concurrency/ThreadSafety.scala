package com.pramshy.concurrency

object ThreadSafety {

  var domain : String = ""

  def setDomain(email : String) : Unit = {
    domain = email.toLowerCase
    domain = domain.split("@")(1)
  }

  def getDomain(): String = domain

  def setDomain2(email : String) : Unit = synchronized {
    domain = email.toLowerCase
    domain = domain.split("@")(1)
  }

  def getDomain2() : String = synchronized {domain}

  def setDomain3(email: String): Unit =  {
    val lowerCase  = email.toLowerCase
    domain = lowerCase.split("@")(1)
  }

  def getDomain3(): String = domain

  def main(args: Array[String]): Unit = {
    setDomain2("foo@bar.com")
    println(getDomain2())
  }
}
