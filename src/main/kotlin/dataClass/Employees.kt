package dataClass

import enum.Position

data class Employees (val company: String = "IDFinance",
                      val position: Position = Position.QA,
                      val name: String = "Tom") {

}