package com.github.textthunder.semanticseditor

import com.github.textthunder.semanticseditor.editor.TestEditor
import org.scalajs.dom
import dom.{Event, document}
import org.scalajs.dom.raw.SVGSVGElement

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("SemanticsEditor")
object SemanticsEditor {
  @JSExport
  def main(arguments: js.Array[String]): Unit = {
    dom.window.addEventListener("load", (_: Event) => {
      val svg = document.createElementNS(
        "http://www.w3.org/2000/svg",
        "svg"
      ).asInstanceOf[
        SVGSVGElement
      ]
      svg.setAttribute(
        "width",
        500.toString
      )
      svg.setAttribute(
        "height",
        500.toString
      )
      document.body.appendChild(
        svg
      )
      TestEditor.readonlyVerticesEditor.render(svg)
    }, useCapture = false)
  }
}
