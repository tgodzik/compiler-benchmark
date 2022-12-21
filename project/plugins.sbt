// Comment to get more information during initialization
logLevel := Level.Warn

// sbt-jmh plugin - pulls in JMH dependencies too
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.3.3")
addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.14")

// required for java9+
val javaxActivation = "com.sun.activation" % "javax.activation" % "1.2.0"

updateOptions := updateOptions.value.withLatestSnapshots(false)

libraryDependencies ++= List(
  javaxActivation
)
