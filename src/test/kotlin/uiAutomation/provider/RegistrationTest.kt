package uiAutomation.provider

import uiAutomation.base.TestBase
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import uiAutomation.provider.WebDriverFactory.Companion.driver

class RegistrationTest: TestBase() {

  @Test
  fun `Checking user registration on the main page`() {
    val expectedResult = "https://qa-delivery-es-release.moneyman.ru/client-area/#/registration?"
    Assertions.assertEquals(expectedResult, Registration().getRegistration(), "Registration failed")
  }
}