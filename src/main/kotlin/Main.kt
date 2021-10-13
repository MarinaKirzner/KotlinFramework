import dataClass.Employees
import factory.PositionFactory
import enum.Position
import singleton.OneObject

fun main() {
  println(OneObject.getInstance())
  val employeePM = Employees("IDFinance",Position.PM, "Tom")
  val employeeQA = employeePM.copy(position = Position.QA)
  val employeeDEV = Employees("IDFinance",Position.DEV, "Bob")

  val name = employeeDEV.component3()
  println(name)

  println(employeeQA)

  val factory = PositionFactory()
  factory.makePosition(Position.PM).make()
  factory.makePosition(Position.QA).make()
  factory.makePosition(Position.DEV).make()



}


