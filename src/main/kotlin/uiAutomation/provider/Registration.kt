package uiAutomation.provider

import uiAutomation.button.ButtonElement.creditAmount
import uiAutomation.button.ButtonElement.loanDays
import uiAutomation.button.ButtonElement.registration
import uiAutomation.button.Locator.Companion.getLocator
import uiAutomation.provider.WebDriverFactory.Companion.driver

class Registration {
  fun getRegistration(): String? {
    creditAmount(getLocator("ButtonElement.creditAmount"))
    loanDays(getLocator("ButtonElement.loanDays"))
    registration(getLocator("ButtonElement.clickRegistration"))
    return driver?.currentUrl
  }
}