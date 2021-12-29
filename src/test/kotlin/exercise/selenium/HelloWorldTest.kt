package exercise.selenium

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class HelloWorldTest {

  @Test
  fun `Search Information about Selenium`() {
    val driver: WebDriver = ChromeDriver()
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.get("https://www.google.by")
    val webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
    webElement.sendKeys("Selenium")
    webElement.submit()

    val searchResults: List<WebElement> = driver.findElements(By.cssSelector(".g"))

    for (searchResult in searchResults) {
      if (searchResult.text.lowercase().contains("Selenium")) {
        fail("Not all elements contain the search phrase")
      }
    }

    driver.quit()
  }
}