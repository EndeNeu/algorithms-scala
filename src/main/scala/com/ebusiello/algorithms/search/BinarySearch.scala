package com.ebusiello.algorithms.search

object BinarySearch {

  def binarySearch[T](collection: Seq[T], value: T)(implicit ordering: Ordering[T]): Int = {
    def search(coll: Seq[T], value: T, indexAcc: Int): Int = {
      val collectionLength = coll.length
      val middleIndex = coll.size / 2
      val middle = coll(middleIndex)
      if(middle == value) middleIndex
      //else if the value is smaller than the middle iterate the first part of the list and reset the index sum param.
      else if (ordering.gt(middle, value)) search(collection.slice(0, middleIndex), value, 0)
      // else iterate the right part and use the index of the middle element as starting point.
      else search(collection.slice(middleIndex, collectionLength), value, indexAcc + middleIndex)
    }

    search(collection.sorted, value, 0)
  }
}