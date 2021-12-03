package core.page

import com.codeborne.selenide.Selenide.open

abstract class BasePage {
  protected abstract val url: String

  fun openPage() {
    open(url)
  }
}