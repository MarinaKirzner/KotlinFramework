package core.watcher

import com.codeborne.selenide.Selenide
import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType

class AllureAttachment {

  @Attachment
  fun attachmentScreenshot() {
    val file = Selenide.screenshot(OutputType.FILE)
    Allure.attachment("Baeldung", FileUtils.openInputStream(file))
  }
}