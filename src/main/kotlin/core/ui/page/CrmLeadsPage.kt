package core.ui.page

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.context.constant.StaticContextHolder.getConfig
import core.ui.element.Link.clickLink
import org.openqa.selenium.By

class CrmLeadsPage : BasePage() {

  override val url: String = getConfig().getCrmUrlWithSelectedEndpoint("/crm#/leads")
  private val crmClientsMenuLocator: By = By.linkText("Клиенты")

  fun verifyPageOpened(){
    super.verifyPageOpen()
    `$`(crmClientsMenuLocator).shouldBe(Condition.visible)
  }

  fun clickCrmClientsPage() {
    clickLink(crmClientsMenuLocator)
  }
}