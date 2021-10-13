package factory.Position

import factory.Company

class PositionPM : Company {
  override fun make() {
    println("PM work with planning and reporting")
  }
}