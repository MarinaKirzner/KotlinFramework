package exercise.selenium.projectArchitecture.core

import exercise.selenium.projectArchitecture.core.WebDriverContainer.Companion.open
import exercise.selenium.projectArchitecture.core.WebDriverContainer.Companion.quit
import exercise.selenium.projectArchitecture.core.WebDriverContainer.Companion.setDriver
import exercise.selenium.projectArchitecture.core.enum.DriverType
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

open class TestBase {
  @BeforeEach
  fun setup() {
    setDriver(DriverType.CHROME)
    open("https://yandex.by/")
  }

  @AfterEach
  fun quitDriver() {
    quit()
  }
}