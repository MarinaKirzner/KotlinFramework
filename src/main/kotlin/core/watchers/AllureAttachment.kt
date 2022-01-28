package core.watchers

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.WebDriverRunner
import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType

class AllureAttachment {

  private val screenshotName: String = "Screenshot"

  @Attachment
  fun attachmentScreenshot() {
    if (WebDriverRunner.hasWebDriverStarted()) {
      Allure.attachment(screenshotName, FileUtils.openInputStream(Selenide.screenshot(OutputType.FILE)))
    }
  }
}