package services.extention

import core.ui.driver.setter.DriverConfigSetter
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import services.page.IpruCrmBasePageOptions
import services.page.IpruCrmLoginPageOptions

class IpruCrmExtension : BeforeEachCallback {
  companion object {
    private val logger: Logger = LogManager.getLogger()
  }

  override fun beforeEach(context: ExtensionContext?) {
    logger.info("Test start ${context?.displayName}")
    DriverConfigSetter().setDriverConfig()
    IpruCrmLoginPageOptions().loginCrm()
    IpruCrmBasePageOptions().apply {
      verifyCrmBasePage()
      openCrmClientsPage()
    }
  }
}