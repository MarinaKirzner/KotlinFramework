package exercise.selenium.customElements

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class Table {

  lateinit var webTable: WebElement

  fun getRowsCount(): Int {
    val rowsCount = listOf(webTable.findElements(By.tagName("tr")))
    return rowsCount.size
  }

  fun getColumnsCount(): Int {
    val firstRow = webTable.findElement(By.tagName("tr"))
    val columnsCount = listOf(firstRow.findElements(By.tagName("td")))
    return columnsCount.size
  }

  fun getCellText(rowIndex: Int, columnIndex: Int): String {
    return getCell(rowIndex, columnIndex).text
  }

  fun getCell(rowIndex: Int, columnIndex: Int): WebElement {
    val rowsCount = listOf(webTable.findElements(By.tagName("tr")))
    val rowNumber = rowsCount.get(rowIndex - 1) as WebElement

    val columnsCount = listOf(rowNumber.findElements(By.tagName("td")))
    val cellText = columnsCount.get(columnIndex - 1) as WebElement

    return cellText
  }
}