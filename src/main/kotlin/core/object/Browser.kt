package core.`object`

import com.codeborne.selenide.WebDriverRunner
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Browser {

  private val logger: Logger = LogManager.getLogger()

  fun getCurrentUrl(url: String): String {
    logger.info("Verify registration URL - $url")
    return WebDriverRunner.url()
  }
}