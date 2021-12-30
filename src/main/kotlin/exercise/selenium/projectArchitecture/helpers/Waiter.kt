package exercise.selenium.projectArchitecture.helpers

import exercise.selenium.projectArchitecture.core.WebDriverContainer.Companion.getWebDriver
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

class Waiter {
  companion object {
    private const val TIME_WAITER = 15
  }

  fun waitFor(condition: ExpectedCondition<Any>) {
    WebDriverWait(getWebDriver(), TIME_WAITER.toLong()).until(condition)
  }

  fun waitForJquery() {
    val executor = getWebDriver() as JavascriptExecutor
    WebDriverWait(getWebDriver(), 1).until { executor.executeScript("return document.readyState") == "complete" }
  }
}
