package core.ui.page

import core.ui.element.TableInformation.getClientInformation
import org.openqa.selenium.By

class CrmClientByIdPage {

  private val cellTypeOfTable: By = By.xpath("//div[1]/div/div[1]/table/tbody/tr/th")
  private val cellTypeDetailsOfTable: By = By.xpath("//div[1]/div/div[1]/table/tbody/tr/td")

  fun selectClientInformation() {
    getClientInformation(cellTypeOfTable, cellTypeDetailsOfTable)
  }
}