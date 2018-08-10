package com.github.textthunder.semanticseditor

import org.scalajs.dom
import dom.{Event, document}

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("SemanticsEditor")
object SemanticsEditor {
  @JSExport
  def main(arguments: js.Array[String]): Unit = {
    dom.window.addEventListener("load", (_: Event) => {
      document.body.appendChild(
        document.createTextNode("Semantics Editor")
      )
    }, useCapture = false)
  }
}
