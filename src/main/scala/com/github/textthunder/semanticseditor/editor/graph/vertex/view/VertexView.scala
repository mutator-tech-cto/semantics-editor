package com.github.textthunder.semanticseditor.editor.graph.vertex.view

import com.github.textthunder.semanticseditor.space.point.Vector2d

case class VertexView(
  position: VertexView.Position
)

object VertexView {
  type Position = Vector2d
}
