package core.ui.block

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

abstract class BaseBlock {
  protected abstract val baseBlockLocator: By

  fun verifyBlockDisplayed() {
    `$`(baseBlockLocator).shouldBe(Condition.visible)
  }
}