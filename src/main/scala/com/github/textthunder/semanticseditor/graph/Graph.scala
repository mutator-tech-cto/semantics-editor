package com.github.textthunder.semanticseditor.graph

import com.github.textthunder.semanticseditor.graph.vertex.storage.VertexStorage

import scala.collection.immutable.TreeMap

case class Graph[ContentType](
  identifier: Graph.Identifier,
  vertices: VertexStorage[ContentType],
  edges: TreeMap[Int, String]
)

object Graph {
  type Identifier = Int
}
