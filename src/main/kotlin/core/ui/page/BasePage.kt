package core.ui.page

import com.codeborne.selenide.Selenide.open
import core.ui.element.Browser.verifyCurrentUrl

abstract class BasePage {
  protected abstract val url: String

  fun openPage() {
    open(url)
  }

  fun isPageOpen() {
    verifyCurrentUrl(url)
  }
}