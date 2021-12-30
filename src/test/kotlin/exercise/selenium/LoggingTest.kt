package exercise.selenium

import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.logging.LogType
import org.openqa.selenium.logging.LoggingPreferences
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import java.util.concurrent.TimeUnit
import java.util.logging.Level

class LoggingTest {

  companion object {
    lateinit var driver: ChromeDriver
  }

  @Test
  fun `Logging Driver`() {
    val logs = LoggingPreferences()
    logs.enable(LogType.DRIVER, Level.OFF)

    val capabilities = DesiredCapabilities()
    capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs)
    driver = ChromeDriver(capabilities)
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.get("https://the-internet.herokuapp.com")

    printLogs()

    driver.quit()
  }

  fun printLogs() {
    val logEntries = driver.manage().logs().get(LogType.DRIVER)
    for (log in logEntries)
      println(log.message)
  }
}