package com.github.textthunder.semanticseditor

import org.scalajs.dom
import dom.{Event, document}

object SemanticsEditor {
  def main(arguments: Array[String]): Unit = {
    document.addEventListener("ready", (_: Event) => {
      document.body.appendChild(
        document.createTextNode("Semantics Editor")
      )
    }, false)
  }
}
