// Comment to get more information during initialization
logLevel := Level.Warn

// sbt-jmh plugin - pulls in JMH dependencies too
addSbtPlugin("pl.project13.scala" % "sbt-jmh" % "0.2.27")
addSbtPlugin("com.lucidchart" % "sbt-scalafmt" % "1.14")

// Let's add our sbt plugin to the sbt too ;)
unmanagedSourceDirectories in Compile ++= {
  val integrationsMainDir = baseDirectory.value.getParentFile.getParentFile / "integrations"
  if (!integrationsMainDir.exists()) Nil
  else {
    val pluginMainDir = integrationsMainDir / "sbt-bloop" / "src" / "main"
    List(
      integrationsMainDir / "core" / "src" / "main" / "scala",
      pluginMainDir / "scala",
      pluginMainDir / s"scala-sbt-${Keys.sbtBinaryVersion.value}"
    )
  }
}
