package core.ui.block

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

abstract class BaseLocator {
  protected abstract val baseBlockLocator: By

  open fun verifyIsBaseBlockDisplayed() {
    `$`(baseBlockLocator).shouldBe(Condition.visible)
  }
}