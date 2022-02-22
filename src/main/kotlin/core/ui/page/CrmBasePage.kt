package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.element.Browser.verifyCurrentUrl
import core.ui.element.Link.clickLink
import org.openqa.selenium.By

class CrmBasePage : BasePage() {

  override val url: String = getConfig().run { getCrmEndpointUrl(crmBaseUrl) }
  private val crmClientsPage: By = By.xpath("//a[@href=\"#/clients\"]")

  fun verifyBasePageUrl() {
    verifyCurrentUrl(url)
  }

  fun openCrmClientsPage() {
    clickLink(crmClientsPage)
  }
}