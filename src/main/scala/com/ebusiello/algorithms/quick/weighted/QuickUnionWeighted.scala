package com.ebusiello.algorithms.quick.weighted

import com.ebusiello.algorithms.quick.QuickGeneric

class QuickUnionWeighted(val length: Int) extends QuickGeneric {

  // initialize the array
  private val nodes = new Array[Int](length)
  private val sizes = new Array[Int](length)
  for (i <- 0 until length) nodes(i) = i
  for (i <- 0 until length) sizes(i) = 1

  /**
    * Two connected nodes have the same root.
    */
  def isConnected(i: Int, j: Int): Boolean =
    if(isIndexValid(i) && isIndexValid(j))findRoot(i) == findRoot(j)
    else throwIndexOutOfBound

  private def findRoot(i: Int): Int = {
    val valueAtI = nodes(i)
    // if the index is equal to the element at that index it means it is the root of itself
    // means we find the root.
    if(valueAtI == i) i
    else findRoot(valueAtI)
  }

  /**
    * To avoid making the tree too deep, always connect the smaller tree to the root of the bigger tree.
    */
  def union(i: Int, j: Int): Unit = {
    if(isIndexValid(i) && isIndexValid(j)) {
      val rootAtI = findRoot(i)
      val rootAtJ = findRoot(j)
      // if the root is the same they are connected.
      if (rootAtI == rootAtJ) ()
      // else if the size of the second tree is bigger, link the root of the first
      // tree to the root of the second and update the depth of the second tree
      else if (sizes(rootAtI) < sizes(rootAtJ)) {
        nodes(rootAtI) = rootAtJ
        sizes(rootAtJ) += sizes(rootAtI)
      }
      // else the other way around.
      else {
        nodes(rootAtJ) = rootAtI
        sizes(rootAtI) += sizes(rootAtJ)
      }
    }
    else throwIndexOutOfBound
  }
}
