package com.ebusiello.algorithms.search

import org.scalatest.{Matchers, WordSpec}

class BinarySearchSpec extends WordSpec with Matchers {

  trait TestContext {
    val col = (1 until 10).toList
    val reverse = (1 until 10).toList.reverse
  }

  "Binary search" should {
    "correctly find the indexes" in new TestContext {
      for (i <- 0 until 10) {
        BinarySearch.binarySearch(col, i) should be(i)
        BinarySearch.binarySearch(reverse, i) should be(i)
      }
    }
  }

}
