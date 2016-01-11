name := "web-tester"

version := "1.0"

scalaVersion := "2.11.7"

fork := true

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0" % "test",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.seleniumhq.selenium" % "selenium-java" % "2.46.0" % "test",
  "org.pegdown" % "pegdown" % "1.0.2" % "test"
)

def chromeDriver = if (System.getProperty("os.name").startsWith("Windows")) "chromedriver.exe" else "chromedriver"
javaOptions += "-Dwebdriver.chrome.driver=" + (baseDirectory.value / "src/test/resources" / chromeDriver).getAbsolutePath

//scalacOptions ++= Seq("-Xlint", "-deprecation", "-unchecked", "-feature", "-flags")
//updateOptions := updateOptions.value.withCachedResolution(true)

