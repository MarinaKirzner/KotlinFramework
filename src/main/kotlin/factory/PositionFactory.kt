package factory

import factory.position.PositionDEV
import factory.position.PositionPM
import factory.position.PositionQA
import enum.PositionType

class PositionFactory {
  fun getPositionFactory(position: PositionType): Position {
    return when(position) {
      PositionType.PM -> PositionPM()
      PositionType.QA -> PositionQA()
      PositionType.DEV -> PositionDEV()
    }
  }
}