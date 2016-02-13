package com.ebusiello.algorithms.quick.union

import com.ebusiello.algorithms.quick.QuickGeneric

class QuickUnion(val length: Int) extends QuickGeneric {

  // initialize the array
  private val nodes: Array[Int] = new Array[Int](length)
  for (i <- 0 until length) nodes(i) = i

  /**
    * Two nodes are connected if the have the same root int he tree
    */
  def isConnected(i: Int, j: Int): Boolean =
    if(isIndexValid(i) && isIndexValid(j)) findRoot(i) == findRoot(j)
    else throwIndexOutOfBound

  /**
    * Iterate the array until the root is found.
    */
  private def findRoot(i: Int): Int = {
    val valueAtI = nodes(i)
    if (valueAtI == i) i
    else findRoot(valueAtI)
  }

  /**
    * Two nodes are connected if they are in the same tree and they have the same root in the array.
    */
  def union(i: Int, j: Int): Unit =
    if (isIndexValid(i) && isIndexValid(j)) {
      val rootAtI = findRoot(i)
      val rootAtJ = findRoot(j)
      if(rootAtI == rootAtJ) () // they have the same root already.
      else {
        nodes(rootAtI) = rootAtJ
      }
    }
    else throwIndexOutOfBound

}
