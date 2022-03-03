package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.block.CrmClientMainDetailsBlock
import core.ui.element.Browser.verifyCurrentUrl

class CrmClientByIdPage(clientId: String) : BasePage() {

  override val url: String = getConfig().getCrmUrlWithSelectedEndpoint("/crm#/clients/$clientId")
  val crmClientDetailsBlock by lazy { CrmClientMainDetailsBlock() }

  fun verifyClientIdPageOpened() {
    verifyCurrentUrl(url)
    crmClientDetailsBlock.verifyBlockDisplayed()
  }
}