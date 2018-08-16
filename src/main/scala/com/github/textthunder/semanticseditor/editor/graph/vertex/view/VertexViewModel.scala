package com.github.textthunder.semanticseditor.editor.graph.vertex.view

import com.github.textthunder.semanticseditor.graph.vertex.content.EditableString
import org.scalajs.dom
import org.scalajs.dom.raw._

case class VertexViewModel[
  VertexModel
](
  model: VertexModel,
  view: VertexView
) {
  def render(implicit svg: SVGSVGElement): SVGElement = {
    model match {
      case EditableString(content) => {
        val svgVertex = dom.document.createElementNS(
          "http://www.w3.org/2000/svg",
          "g"
        ).asInstanceOf[
          SVGGElement
        ]

        val svgString = dom.document.createElementNS(
          "http://www.w3.org/2000/svg",
          "text"
        ).asInstanceOf[
          SVGTextElement
        ]
        svgString.textContent = content
        val transformations = svgVertex.transform.baseVal
        transformations.appendItem({
          val svgTransform = svg.createSVGTransform()
          svgTransform.setTranslate(
            view.position.x,
            view.position.y
          )
          svgTransform
        })
        svgVertex.appendChild(svgString)
        svg.appendChild(svgVertex)

        val svgStringBBox = svgString.getBBox()

        val svgBox = dom.document.createElementNS(
          "http://www.w3.org/2000/svg",
          "rect"
        ).asInstanceOf[
          SVGRectElement
        ]
        svgBox.setAttribute("width", s"${svgStringBBox.width + 2}")
        svgBox.setAttribute("height", s"${svgStringBBox.height + 2}")
        svgBox.setAttribute("fill", "white")
        svgBox.setAttribute("stroke", "blue")

        val boxTransformations = svgBox.transform.baseVal
        boxTransformations.appendItem({
          val svgTransform = svg.createSVGTransform()
          svgTransform.setTranslate(
            -1,
            -svgStringBBox.height + 1
          )
          svgTransform
        })

        svgVertex.insertBefore(svgBox, svgString)
        svgVertex
      }
    }
  }
}
