package exercise.selenium

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

class WaitTest {

  companion object {
    private val driver: WebDriver = ChromeDriver()
  }

  @BeforeEach
  fun `SetDriver`() {
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS)
    driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS)
  }

  @Test
  fun `Search Information about Selenium`() {
    driver.get("https://the-internet.herokuapp.com/dynamic_loading/1")
    val startElement = driver.findElement(By.cssSelector("#start > button"))
    startElement.click()

    val finishElement = driver.findElement(By.cssSelector("#finish > h4"))
    finishElement.click()

    val wait = WebDriverWait(driver, 5)
    val webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")))
    webElement.click()
  }

  @AfterEach
  fun `CloseBrowser`() {
    driver.quit()
  }
}