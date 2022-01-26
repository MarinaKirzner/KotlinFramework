package core.watcher

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher

class TafTestWatcher : TestWatcher {
  private val logger: Logger = LogManager.getLogger()

  override fun testFailed(context: ExtensionContext, cause: Throwable?) {
    logger.info("Test Failed for test {}: ", context.displayName)
    AllureAttachment().attachmentScreenshot()
  }
}