package factory.position

import factory.Position

class PositionQA : Position {
  override fun creatPosition(): String {
    val position = "QA work with planning and reporting"
    println(position)
    return position
  }
}