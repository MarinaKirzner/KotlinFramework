package core.page

import com.codeborne.selenide.Selenide.open

abstract class BasePage {
  abstract val url: String

  open fun openPage() {
    open(url)
  }
}