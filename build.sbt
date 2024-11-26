ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

lazy val root = (project in file("."))
  .settings(
    name := "scala_begin"
  )

val AkkaVersion = "2.8.5"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion
