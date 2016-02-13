package com.ebusiello.algorithms.quick

trait IndexValidator {

  val length: Int

  def isIndexValid(i: Int): Boolean =
    i >= 0 && i < length

}
