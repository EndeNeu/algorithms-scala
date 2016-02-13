package com.ebusiello.algorithms.quick.find

import com.ebusiello.algorithms.quick.IndexValidator

class QuickFind(val length: Int) extends IndexValidator {

  // initialize the array
  val nodes = new Array[Int](length)
  for(i <-0 until length) nodes(i) = i

  /**
    * If two nodes are connected the will have the same value in the array
    */
  def isConnected(i: Int, j: Int): Boolean =
    if(isIndexValid(i) && isIndexValid(j))
      nodes(i) == nodes(j)
    else
      throw new IndexOutOfBoundsException("Index out of bound.")

  /**
    * Change all the values equal to the one at position i to the value at position j
    */
  def union(i: Int, j: Int): Unit =
    if(isConnected(i, j)) ()
    else {
      val valueAtI = nodes(i)
      val valueAtJ = nodes(j)
      for (i <-0 until length)
        if(nodes(i) == valueAtI) nodes(i) = valueAtJ
    }

}
