package core.watchers

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher

class TafTestWatcher : TestWatcher, BeforeEachCallback {
  companion object {
    private val logger: Logger = LogManager.getLogger()
  }

  override fun beforeEach(context: ExtensionContext?) {
    logger.info("Test start ${context?.displayName}")
  }

  override fun testFailed(context: ExtensionContext, cause: Throwable?) {
    logger.info("Test Failed for test ${context.displayName}")
    AllureAttachment().attachmentScreenshot()
  }
}