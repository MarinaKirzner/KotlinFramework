package factory

import enum.PositionType

class PositionManager {
  fun creatPositionType(position: PositionType): String {
    return PositionFactory().getPositionFactory(position).creatPosition()
  }
}