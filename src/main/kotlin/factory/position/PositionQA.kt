package factory.position

import factory.Position

class PositionQA : Position {
  companion object {
    const val position: String = "QA created"
  }

  override fun createPosition(): String {
    println(position)
    return position
  }
}