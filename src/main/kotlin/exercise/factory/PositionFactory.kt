package exercise.factory

import exercise.enum.PositionType
import exercise.factory.position.PositionDEV
import exercise.factory.position.PositionPM
import exercise.factory.position.PositionQA

class PositionFactory {
  fun getPositionFactory(position: PositionType): Position {
    return when (position) {
      PositionType.PM -> PositionPM()
      PositionType.QA -> PositionQA()
      PositionType.DEV -> PositionDEV()
    }
  }
}