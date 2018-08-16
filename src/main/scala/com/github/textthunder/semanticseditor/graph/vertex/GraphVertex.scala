package com.github.textthunder.semanticseditor.graph.vertex

import com.github.textthunder.semanticseditor.storage.index.StorageIndex

case class GraphVertex[ContentType](
  content: ContentType
)

object GraphVertex {
  case class Identifier(
    value: Int
  ) extends StorageIndex[
    GraphVertex.Identifier
  ]

  object Identifier {
    object Orderable
      extends Ordering[
        GraphVertex.Identifier
      ]
    {
      override def compare(left: GraphVertex.Identifier, right: GraphVertex.Identifier): Int = {
        if (left.value < right.value) {
          -1
        } else if (left.value > right.value) {
          1
        } else {
          0
        }
      }
    }

    def next: Option[GraphVertex.Identifier] => GraphVertex.Identifier = {
      case (identifier: Option[GraphVertex.Identifier]) => {
        identifier match {
          case None => {
            GraphVertex.Identifier(0)
          }
          case Some(previousIdentifier) => {
            GraphVertex.Identifier(previousIdentifier.value + 1)
          }
        }
      }
    }
  }
}
