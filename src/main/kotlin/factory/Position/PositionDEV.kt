package factory.Position

import factory.Company

class PositionDEV : Company {
  override fun make() {
    println("DEV writes program code")
  }
}