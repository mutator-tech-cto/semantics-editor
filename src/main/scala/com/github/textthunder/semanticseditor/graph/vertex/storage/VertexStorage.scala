package com.github.textthunder.semanticseditor.graph.vertex.storage

import com.github.textthunder.semanticseditor.graph.vertex.GraphVertex
import com.github.textthunder.semanticseditor.storage.IndexStorage

import scala.collection.immutable.TreeMap

class VertexStorage[ContentType](
  indices: TreeMap[GraphVertex.Identifier, GraphVertex.Identifier],
  values: TreeMap[GraphVertex.Identifier, GraphVertex[ContentType]]
) extends IndexStorage[GraphVertex.Identifier, GraphVertex[ContentType]](
  indices,
  None,
  values
)

object VertexStorage {
  def apply[ContentType](
    indices: TreeMap[GraphVertex.Identifier, GraphVertex.Identifier],
    values: TreeMap[GraphVertex.Identifier, GraphVertex[ContentType]]
  ): VertexStorage[ContentType] = {
    new VertexStorage(
      indices,
      values
    )
  }
}