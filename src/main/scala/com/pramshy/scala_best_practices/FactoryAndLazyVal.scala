package com.pramshy.scala_best_practices

// Using a factory and lazy val pattern
object FactoryAndLazyVal {

  private var jdbcURLFactory : Option[() => String] = None
  private var usernameFactory : Option[() => String] = None
  private var passwordFactory : Option[() => String] = None

  private lazy val jdbcURL = jdbcURLFactory.getOrElse(() => "jdbc:mysql://localhost:3306")()
  private lazy val username = usernameFactory.getOrElse(() => "root")()
  private lazy val password = passwordFactory.getOrElse(() => "")()

  def main(args: Array[String]): Unit = {

    println(s"JDBC URL: $jdbcURL")
    println(s"Username: $username")
    passwordFactory = Some(() => "tester")
    println(s"Password: $password")

    println(s"Password: $password")
  }

}
