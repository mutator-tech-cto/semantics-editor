package com.github.textthunder.semanticseditor.storage

import com.github.textthunder.semanticseditor.storage.index.StorageIndex

import scala.collection.immutable.TreeMap

class IndexStorage[
  Index <: StorageIndex[Index],
  Value
](
  var indices: TreeMap[Index, Index],
  var maxIndex: Option[Index],
  var values: TreeMap[Index, Value]
) {
  def insert(
    nextIndex: Option[Index] => Index,
    value: Value
  ): this.type = {
    val index = nextIndex(this.maxIndex)
    this.indices = this.indices.updated(
      index,
      index
    )
    this.values = this.values.updated(
      index,
      value
    )
    this.maxIndex = Some(index)
    this
  }
}
