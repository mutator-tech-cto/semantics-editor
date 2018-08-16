package com.github.textthunder.semanticseditor.editor

import com.github.textthunder.semanticseditor.editor.graph.vertex.view.{VertexView, VertexViewModel}
import com.github.textthunder.semanticseditor.graph.Graph
import com.github.textthunder.semanticseditor.graph.vertex.GraphVertex
import com.github.textthunder.semanticseditor.graph.vertex.content.EditableString
import com.github.textthunder.semanticseditor.graph.vertex.storage.VertexStorage
import com.github.textthunder.semanticseditor.space.point.Vector2d

import scala.collection.immutable.TreeMap

object TestEditor {
  val readonlyVerticesEditor = Editor(
    editableGraph = Graph(
      identifier = 0,
      vertices = VertexStorage[
          VertexViewModel[
            EditableString
          ]
        ](
        TreeMap.empty[
          GraphVertex.Identifier,
          GraphVertex.Identifier
        ](GraphVertex.Identifier.Orderable),
        TreeMap.empty[
          GraphVertex.Identifier,
          GraphVertex[
            VertexViewModel[
              EditableString
            ]
          ]
        ](GraphVertex.Identifier.Orderable)
      ).insert(
        GraphVertex.Identifier.next,
        GraphVertex[VertexViewModel[EditableString]](
          VertexViewModel(
            model = EditableString("Alpha"),
            view = VertexView(
              position = Vector2d(
                100,
                100
              )
            )
          )
        )
      ).insert(
        GraphVertex.Identifier.next,
        GraphVertex[VertexViewModel[EditableString]](
          VertexViewModel(
            model = EditableString("Beta"),
            view = VertexView(
              position = Vector2d(
                200,
                300
              )
            )
          )
        )
      ).insert(
        GraphVertex.Identifier.next,
        GraphVertex[VertexViewModel[EditableString]](
          VertexViewModel(
            model = EditableString("Gamma"),
            view = VertexView(
              position = Vector2d(
                400,
                100
              )
            )
          )
        )
      ),
      edges = TreeMap.empty
    )
  )
}
