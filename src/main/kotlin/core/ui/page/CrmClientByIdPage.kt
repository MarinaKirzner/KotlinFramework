package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.block.CrmClientMainDetailsBlock
import core.ui.element.Browser.verifyCurrentUrl

class CrmClientByIdPage(clientId: String) : BasePage() {

  override val url: String = getConfig().getCrmUrlWithSelectedEndpoint("/crm#/clients/$clientId")
  val crmClientMainDetailsBlock by lazy { CrmClientMainDetailsBlock() }

  fun verifyClientIdPageOpened() {
    verifyCurrentUrl(url)
    crmClientMainDetailsBlock.verifyBlockDisplayed()
  }

  fun getCrmClientIdDetails(): Map<String, Any> {
    val clientIdDetails: Map<String, Any> = crmClientMainDetailsBlock.getClientMainDetailsFromTable()
    clientIdDetails as MutableMap
    return clientIdDetails.apply {
      remove("Согласие на ПЭП")
      remove("Согласие на проверку")
    }
  }
}