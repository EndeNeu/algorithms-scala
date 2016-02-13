package com.ebusiello.algorithms.quick

trait QuickGeneric {

  def length: Int

  def isIndexValid(i: Int): Boolean =
    i >= 0 && i < length

  def throwIndexOutOfBound =
    throw new IndexOutOfBoundsException("Index out of bound.")

}
