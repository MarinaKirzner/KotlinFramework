package factory.position

import factory.Position

class PositionPM : Position {
  override fun creatPosition(): String {
    val position = "PM work with planning and reporting"
    println(position)
    return position
  }
}