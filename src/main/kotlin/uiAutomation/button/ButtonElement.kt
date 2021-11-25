package uiAutomation.button

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By
import org.openqa.selenium.Keys

object ButtonElement {

  fun acceptCookies(btnCookies: By) {
    `$`(btnCookies).click()
  }

  fun creditAmount(locatorCredit: By) {
    Thread.sleep(3000)
    `$`(locatorCredit).sendKeys(Keys.chord(Keys.CONTROL,"a"), "100")
  }

  fun loanDays(locatorDays: By) {
    Thread.sleep(3000)
    `$`(locatorDays).sendKeys(Keys.chord(Keys.CONTROL,"a"), "7")
  }

  fun registration(btnRegistration: By) {
    `$`(btnRegistration).click()
    Thread.sleep(3000)
  }

}