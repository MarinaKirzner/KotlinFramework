package exercise.selenium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class WebStorageTest {

  companion object {
    val driver = ChromeDriver()
  }

  @Test
  fun `Web Storage clear`() {
    val localStr = "Local"
    val sessionStr = "Session"

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.manage().window().maximize()
    driver.get("https://bestvpn.org/html5demos/storage/")

    driver.findElement(By.id("session")).sendKeys(sessionStr)
    driver.findElement(By.id("local")).sendKeys(localStr)

    val js = driver as JavascriptExecutor
    val localStorage = js.executeScript("return localStorage.value;") as String
    val sessionStorage = js.executeScript("return sessionStorage.value;") as String

    Assertions.assertEquals(localStorage, localStr)
    Assertions.assertEquals(sessionStorage, sessionStr)

    Thread.sleep(3000)
    driver.quit()
  }
}