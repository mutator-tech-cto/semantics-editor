package com.github.textthunder.semanticseditor.storage.index

trait StorageIndex[Index <: StorageIndex[Index]]

object StorageIndex {
  abstract class Orderable[Index <: StorageIndex[Index]]
    extends Ordering[Index]
  {
    def compare(that: Index): Int
  }
}
