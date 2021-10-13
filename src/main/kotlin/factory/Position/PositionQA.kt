package factory.Position

import factory.Company

class PositionQA : Company {
  override fun make() {
    println("QA is working on testing the project")
  }
}