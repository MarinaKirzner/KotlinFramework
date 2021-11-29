package core.`object`

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.Selenide.webdriver
import core.page.LandingPage
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import java.awt.SystemColor.info

object ClickButton {

  fun clickButton(element: By) {
    sleep(3000)
    webdriver().driver().webDriver.findElement(element).click()
  }
}
