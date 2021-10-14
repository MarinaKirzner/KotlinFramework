package dataClass

import enum.PositionType

data class Employees (val company: String = "IDFinance",
                      val position: PositionType = PositionType.QA,
                      val name: String = "Tom") {

}