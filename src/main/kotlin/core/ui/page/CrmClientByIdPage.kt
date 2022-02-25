package core.ui.page

import core.context.constant.StaticContextHolder
import core.ui.block.CrmClientMainDetailsBlock
import core.ui.element.Browser.verifyCurrentUrl

class CrmClientByIdPage : BasePage() {

  override val url: String = StaticContextHolder.getConfig().getCrmUrlWithSelectedEndpoint("/crm#/clients/%s")
  private val crmClientDetailsBlock by lazy { CrmClientMainDetailsBlock() }

  fun verifyClientIdPageOpened(id: String) {
    verifyCurrentUrl(String.format(url, id))
    crmClientDetailsBlock.verifyDetailsBlockDisplayed()
  }

  fun getClientIdDetailsFromTable(): Map<String, String> {
    return crmClientDetailsBlock.getClientIdMainDetailsFromTable()
  }
}