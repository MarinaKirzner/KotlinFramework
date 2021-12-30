package exercise.data_class

import exercise.enum.PositionType

data class Employee(
  val company: String,
  val position: PositionType,
  val name: String
)