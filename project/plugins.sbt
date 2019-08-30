// Comment to get more information during initialization
logLevel := Level.Warn

// sbt-jmh plugin - pulls in JMH dependencies too
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.3.3")
addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.14")

// Enable this for the bloop build to work
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.1")

// required for java9+
val javaxActivation = "com.sun.activation" % "javax.activation" % "1.2.0"

addSbtPlugin("ch.epfl.scala" % "sbt-bloop-build-shaded" % "1.0.0-SNAPSHOT")
updateOptions := updateOptions.value.withLatestSnapshots(false)

libraryDependencies ++= List(
  javaxActivation
)
