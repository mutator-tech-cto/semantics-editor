val graphEditor = (
	project in file(".")
).enablePlugins(
	ScalaJSPlugin
).settings(
	name := "Scala.js Tutorial",
	scalaVersion := "2.12.6",
	scalaJSUseMainModuleInitializer := true
)

