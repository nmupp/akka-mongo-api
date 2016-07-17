name := "planops-akka-api"
version := "1.0"
scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-core" % "2.4.7",
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.7",
  "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.4.7",
  "org.reactivemongo" %% "reactivemongo" % "0.11.14",
  "org.slf4j" % "slf4j-simple" % "1.6.4"
)