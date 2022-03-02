package core.ui.page

import com.codeborne.selenide.Selenide.`$`
import core.context.constant.StaticContextHolder.getConfig
import core.ui.block.CrmClientsFilterBlock
import core.ui.block.CrmClientsTableBlock
import core.ui.element.Link.clickLink
import org.openqa.selenium.By

class CrmClientPage : BasePage() {

  override val url: String = getConfig().getCrmUrlWithSelectedEndpoint("/crm#/clients")
  private val clientIdFirstRowLocator: By = By.xpath("//td/a")
  val crmClientFilterBlock by lazy { CrmClientsFilterBlock() }
  val crmClientsTableBlock by lazy { CrmClientsTableBlock() }
  val clientId: String = `$`(clientIdFirstRowLocator).text

  fun verifyPageOpened() {
    super.verifyPageOpen()
    crmClientsTableBlock.verifyBlockDisplayed()
  }

  fun openClientIdPage() {
    clickLink(clientIdFirstRowLocator)
  }
}