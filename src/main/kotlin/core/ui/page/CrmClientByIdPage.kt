package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.block.CrmClientByIdTableMainDetailsBlock
import core.ui.element.Browser.verifyCurrentUrl

class CrmClientByIdPage : BasePage() {

  override val url: String = getConfig().run { getCrmEndpointUrl("$crmClientsUrl/%s") }

  fun verifyClientByIdPageUrl(id: String) {
    verifyCurrentUrl(String.format(url, id))
  }

  fun verifyClientIdInformationBlock() {
    CrmClientByIdTableMainDetailsBlock().verifyClientIdTableBlock()
  }

  fun selectClientMainInformation() {
    CrmClientByIdTableMainDetailsBlock().selectClientIdDetailsFromTableBlock()
  }
}