package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.element.Browser.verifyCurrentUrl
import core.ui.element.Browser.verifyElementIsVisible
import core.ui.element.Button.clickButton
import core.ui.element.Dropdown.setValueInDropdown
import core.ui.element.Link.clickLink
import org.openqa.selenium.By

class CrmClientPage : BasePage() {

  override val url: String = getConfig().getCrmClientsUrl()
  private val crmClientsPage: By = By.xpath("//a[@href=\"#/clients\"]")
  private val crmClientsPageFilter: By = By.xpath("//form[@data-test-id=\"Clients Filter\"]")
  private val crmClientTypeByDropdown: By = By.id("TYPE")
  private val crmSearchButton: By = By.xpath("//button[text()='Искать']")
  private val crmTableOfClients: By = By.xpath("//div[@data-test-id=\"Clients Table\"]")

  fun getCrmClientsPage() {
    clickButton(crmClientsPage)
  }

  fun verifyClientsPageUrl() {
    verifyCurrentUrl(url)
  }

  fun verifyClientsFilterByPage() {
    verifyElementIsVisible(crmClientsPageFilter)
  }

  fun selectClientTypeByDropdown(valueClientType: String) {
    setValueInDropdown(crmClientTypeByDropdown, valueClientType)
    clickButton(crmSearchButton)
  }

  fun verifyClientsTableFromPage() {
    verifyElementIsVisible(crmTableOfClients)
  }

  fun selectClientById(clientId: String) {
    val crmClientId: By = By.xpath("//a[text()=$clientId]")
    clickLink(crmClientId)
  }

  fun verifyClientByIdPageUrl(clientId: String) {
    verifyCurrentUrl("$url/$clientId")
  }
}