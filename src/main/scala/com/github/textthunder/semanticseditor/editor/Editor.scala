package com.github.textthunder.semanticseditor.editor

import com.github.textthunder.semanticseditor.editor.graph.vertex.view.VertexViewModel
import com.github.textthunder.semanticseditor.graph.Graph
import com.github.textthunder.semanticseditor.graph.vertex.content.EditableString
import org.scalajs.dom.raw.SVGSVGElement

case class Editor(
  editableGraph: Graph[
    VertexViewModel[
      EditableString
    ]
  ]
) {
  def render(svg: SVGSVGElement): Unit = {
    this.editableGraph.vertices.values.map({
      case (_, value) => {
        value.content.render(svg)
      }
    })
  }
}
