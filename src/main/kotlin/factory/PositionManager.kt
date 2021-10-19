package factory

import enum.PositionType

class PositionManager {
  fun createPositionType(position: PositionType): String {
    return PositionFactory().getPositionFactory(position).createPosition()
  }
}