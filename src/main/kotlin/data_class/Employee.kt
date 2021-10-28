package data_class

import enum.PositionType

data class Employee(
  val company: String,
  val position: PositionType,
  val name: String
)