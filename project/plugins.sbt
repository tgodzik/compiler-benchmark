// Comment to get more information during initialization
logLevel := Level.Warn

// sbt-jmh plugin - pulls in JMH dependencies too
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.3.3")
addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.14")

// Enable this for the bloop build to work
//addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.1.0-M13-2")

// required for java9+
val javaxActivation = "com.sun.activation" % "javax.activation" % "1.2.0"

//addSbtPlugin("ch.epfl.scala" % "sbt-bloop-build-shaded" % "1.0.0-SNAPSHOT")
updateOptions := updateOptions.value.withLatestSnapshots(false)

libraryDependencies ++= List(
  javaxActivation
)

val `bloop-shaded-plugin` = project
  .settings(
    sbtPlugin := true,
    exportJars := true,
    scalaVersion := "2.12.9",
    compileInputs in Compile in compile := {
      val inputs = (compileInputs in Compile in compile).value
      val classDir = (classDirectory in Compile).value
      val shadingJar = baseDirectory.value.getParentFile.getParentFile.getParentFile / "project" / "project" / "target" / "sbt-bloop-build-shaded" / "target" / "scala-2.12" / "sbt-1.0" / "sbt-bloop-build-shaded-raw-1.0.0-SNAPSHOT-shading.jar"
      IO.unzip(shadingJar, classDir)
      IO.delete(classDir / "META-INF" / "MANIFEST.MF")
      inputs
    }
  )

dependsOn(`bloop-shaded-plugin`)
