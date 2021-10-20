package factory.position

import factory.Position

class PositionDEV : Position {
  companion object {
    const val position: String = "DEV created"
  }

  override fun createPosition(): String {
    println(position)
    return position
  }
}