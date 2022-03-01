package core.ui.page

import com.codeborne.selenide.Selenide.`$`
import core.context.constant.StaticContextHolder
import core.ui.block.CrmClientMainDetailsBlock
import core.ui.element.Browser.verifyCurrentUrl
import org.openqa.selenium.By

class CrmClientByIdPage(clientId: String = `$`(By.tagName("h2")).text.split(" ").last()) : BasePage() {

  override val url: String = StaticContextHolder.getConfig().getCrmUrlWithSelectedEndpoint("/crm#/clients/$clientId")
  private val crmClientDetailsBlock by lazy { CrmClientMainDetailsBlock() }

  fun verifyClientIdPageOpened() {
    verifyCurrentUrl(url)
    crmClientDetailsBlock.verifyClientDetailsBlockDisplayed()
  }

  fun getClientIdDetailsFromTable(): Map<String, String> {
    return crmClientDetailsBlock.getClientIdMainDetailsFromTable()
  }
}