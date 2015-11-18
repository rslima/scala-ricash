lazy val ricash = (project in file(".")).
  settings(
    name := "ricash",
    organization := "com.rslima",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-core" % "0.10.1",
      "org.http4s" %% "http4s-jetty" % "0.10.1",
      "org.http4s" %% "http4s-dsl" % "0.10.1",
      "org.http4s" %% "http4s-argonaut" % "0.10.1",
      "org.tpolecat" %% "doobie-core" % "0.2.3",
      "org.tpolecat" %% "doobie-contrib-postgresql" % "0.2.3",
      "org.tpolecat" %% "doobie-contrib-hikari" % "0.2.3",
      "ch.qos.logback" % "logback-classic" % "1.1.3"
    )
  )
