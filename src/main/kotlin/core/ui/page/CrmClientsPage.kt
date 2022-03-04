package core.ui.page

import com.codeborne.selenide.Selenide.`$`
import core.context.constant.StaticContextHolder.getConfig
import core.ui.block.CrmClientsFilterBlock
import core.ui.block.CrmClientsSearchResultsBlock
import core.ui.element.Link.clickLink
import org.openqa.selenium.By

class CrmClientsPage : BasePage() {

  override val url: String = getConfig().getCrmUrlWithSelectedEndpoint("/crm#/clients")
  private val clientIdRowLocator: By = By.xpath("//td/a/")
  private val selectClientId: String = "//a[text()='%s']"
  val crmClientsFilterBlock by lazy { CrmClientsFilterBlock() }
  val crmClientsSearchResultsBlock by lazy { CrmClientsSearchResultsBlock() }

  fun verifyPageOpened() {
    super.verifyPageOpen()
    crmClientsFilterBlock.verifyBlockDisplayed()
  }

  fun getClientIdFromSearchResults(): String {
    return `$`(clientIdRowLocator).text
  }

  fun openSelectedClientIdPage(clientId: String) {
    clickLink(By.xpath(String.format(selectClientId, clientId)))
  }
}