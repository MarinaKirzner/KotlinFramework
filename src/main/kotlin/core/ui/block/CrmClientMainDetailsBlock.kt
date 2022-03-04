package core.ui.block

import core.ui.element.TableInformation.getTableValues
import org.openqa.selenium.By

class CrmClientMainDetailsBlock : BaseBlock() {

  override val baseBlockLocator: By = By.xpath("//h4[text()='Общая информация']/ancestor::table")

  private fun convertValueInBoolean(field: String, map: Map<String, String>): String {
    return if (map.filter { it.key == field }.entries.first().value == "Да" ||
      map.filter { it.key == field }.entries.first().value == "1"
    ) "true"
    else "false"
  }

  fun getClientIdMainDetailsFromTable(): Map<String, String> {
    val crmClientMainDetails: MutableMap<String, String> = getTableValues(baseBlockLocator) as MutableMap<String, String>
    crmClientMainDetails.apply {
      remove("Согласие на ПЭП")
      remove("Согласие на проверку")
      put("Резидент", convertValueInBoolean("Резидент", this))
      put("Менялись ли ФИО?", convertValueInBoolean("Менялись ли ФИО?", this))
    }
    return crmClientMainDetails
  }
}