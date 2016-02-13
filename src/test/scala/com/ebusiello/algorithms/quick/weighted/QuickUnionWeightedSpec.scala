package com.ebusiello.algorithms.quick.weighted

import org.scalatest.{Matchers, WordSpecLike}

class QuickUnionWeightedSpec extends WordSpecLike with Matchers {

  trait TestContext {
    val qu = new QuickUnionWeighted(10)
  }

  "quikcFind" should {
    "be disconnected on init" in new TestContext {
      for (i <- 0 until 10) {
        for (j <- 0 until 10) {
          if(i != j)
            qu.isConnected(i, j) should be(false)
        }
      }
    }

    "correctly connect" in new TestContext {
      qu.union(4,3)
      qu.isConnected(3,4) should be(true)
      qu.union(3,8)
      qu.union(6,5)
      qu.union(9,4)
      qu.union(2,1)
      qu.union(8,9)
      qu.union(5,0)
      qu.union(7,2)
      qu.union(6,1)
      qu.isConnected(8,9) should be(true)
      qu.isConnected(0,7) should be(true)
      qu.isConnected(5,7) should be(true)
    }

    "throw fro wrong input" in new TestContext {
      intercept[IndexOutOfBoundsException] {
        qu.isConnected(100, -100)
      }
      intercept[IndexOutOfBoundsException] {
        qu.union(100, -100)
      }
    }
  }
}
