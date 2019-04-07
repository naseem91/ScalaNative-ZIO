enablePlugins(ScalaNativePlugin)

name := "ScalaNative-ZIO"

version := "0.1"

scalaVersion := "2.11.12"

nativeLinkStubs := true

libraryDependencies += "org.scalaz" %% "scalaz-zio" % "1.0-RC3"

