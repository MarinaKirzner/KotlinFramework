package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.element.Browser.verifyCurrentUrl

class CrmBasePage {

  private val crmBaseUrl: String = getConfig().getCrmBaseUrl()

  fun verifyBasePageUrl() {
    verifyCurrentUrl(crmBaseUrl)
  }
}