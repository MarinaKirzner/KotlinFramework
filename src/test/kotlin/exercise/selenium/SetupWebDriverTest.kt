package exercise.selenium

import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeDriver

class SetupWebDriverTest {

  @Test
  fun `Open Google page`() {
    val driver = ChromeDriver()
    driver.get("https://www.google.by")
  }
}