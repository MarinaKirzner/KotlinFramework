package exercise.selenium.projectArchitecture.core

import exercise.selenium.projectArchitecture.core.WebDriverContainer.Companion.getWebDriver
import org.junit.jupiter.api.Assertions

open class PageBase {

  fun assertTitle(title: String) {
    Assertions.assertEquals(getWebDriver().getTitle(), title, "Different titles")
  }
}