package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.block.CrmClientsFilterBlock
import core.ui.block.CrmClientsTableBlock
import core.ui.element.Browser.verifyCurrentUrl

class CrmClientPage : BasePage() {

  override val url: String = getConfig().run { getCrmEndpointUrl(crmClientsUrl) }

  fun verifyCrmClientsPage() {
    verifyCurrentUrl(url)
  }

  fun selectClientTypeByFilter(valueClientType: String) {
    CrmClientsFilterBlock().apply {
      verifyFilterByClientsBlock()
      selectClientTypeInFilterBlock(valueClientType)
    }
  }

  fun selectClientIdFromTable(id: String) {
    CrmClientsTableBlock().apply {
      verifyClientsTableBlock()
      selectClientIdFromTableBlock(id)
    }
  }
}