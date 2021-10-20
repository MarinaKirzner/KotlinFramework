package factory.position

import factory.Position

class PositionPM : Position {
  companion object {
    const val position: String = "PM created"
  }

  override fun createPosition(): String {
    println(position)
    return position
  }
}