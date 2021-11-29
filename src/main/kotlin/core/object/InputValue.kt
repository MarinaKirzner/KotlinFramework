package core.`object`

import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.Selenide.webdriver
import org.openqa.selenium.By
import org.openqa.selenium.Keys

object InputValue {
  fun setInputValue(element: By, value: String) {
    sleep(3000)
    webdriver().driver().webDriver.findElement(element).sendKeys(Keys.CONTROL,"a")
    webdriver().driver().webDriver.findElement(element).sendKeys(value)
  }
}