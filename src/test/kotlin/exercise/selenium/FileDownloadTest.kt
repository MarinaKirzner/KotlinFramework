package exercise.selenium

import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class FileDownloadTest {

  companion object {
    val driver = ChromeDriver()
  }

  @Test
  fun `File download`() {
    val url = driver.get("https://the-internet.herokuapp.com/download")
    val link = driver.findElement(By.cssSelector("div example>a")).getAttribute("href")
  }
}