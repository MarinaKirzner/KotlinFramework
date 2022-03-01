package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.block.CrmClientsFilterBlock
import core.ui.block.CrmClientsTableBlock
import core.ui.element.Link.clickLink
import org.openqa.selenium.By

class CrmClientPage : BasePage() {

  override val url: String = getConfig().getCrmUrlWithSelectedEndpoint("/crm#/clients")
  private val clientIdFirstRowLocator: By = By.xpath("//td/a")
  private val crmClientFilterBlockLocator by lazy { CrmClientsFilterBlock() }
  val crmClientsTableBlock by lazy { CrmClientsTableBlock() }

  fun verifyPageOpened() {
    super.verifyPageOpen()
    crmClientsTableBlock.verifyClientDetailsBlockDisplayed()
  }

  fun selectClientTypeByFilter(valueClientType: String) {
    crmClientFilterBlockLocator.selectClientTypeByFilterBlock(valueClientType)
  }

  fun clickSearchButtonByFilter() {
    crmClientFilterBlockLocator.clickSearchButtonByFilterBlock()
  }

  fun openClientIdPage() {
    clickLink(clientIdFirstRowLocator)
  }
}