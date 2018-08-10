val graphEditor = (
	project in file(".")
).enablePlugins(
	ScalaJSPlugin
).settings(
	name := "semantics-editor",
	organization := "com.github.textthunder",
  version := "0.1.0-SNAPSHOT",
  libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.6",
	scalaVersion := "2.12.6",
  scalaJSUseMainModuleInitializer := false
)
