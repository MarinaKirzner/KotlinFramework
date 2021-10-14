package factory.position

import factory.Position

class PositionDEV : Position {
  override fun creatPosition(): String {
    val position = "DEV work with planning and reporting"
    println(position)
    return position
  }
}