package factory

import factory.Position.PositionDEV
import factory.Position.PositionPM
import factory.Position.PositionQA
import enum.Position

class PositionFactory {
  fun makePosition(position: Position): Company {
    return when(position) {
      Position.PM -> PositionPM()
      Position.QA -> PositionQA()
      Position.DEV -> PositionDEV()
    }
  }
}