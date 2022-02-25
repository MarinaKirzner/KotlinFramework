package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.block.CrmClientsFilterBlock
import core.ui.block.CrmClientsTableBlock
import core.ui.element.Link.clickLink
import org.openqa.selenium.By

class CrmClientPage : BasePage() {

  override val url: String = getConfig().getCrmUrlWithSelectedEndpoint("/crm#/clients")
  private val clientId: String = "//a[text()='%s']"
  val crmClientFilter by lazy { CrmClientsFilterBlock() }
  private val crmClientsTable by lazy { CrmClientsTableBlock() }

  fun verifyPageOpened() {
    super.isPageOpen()
    crmClientsTable.verifyDetailsBlockDisplayed()
  }

  fun selectClientTypeByFilter(valueClientType: String) {
    crmClientFilter.selectClientTypeByFilterBlock(valueClientType)
  }

  fun openClientIdPage(id: String) {
    val crmClientId: By = By.xpath(String.format(clientId, id))
    clickLink(crmClientId)
  }
}