package exercise.selenium

import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class LocatorsTest {

  @Test
  fun `Locators`() {
    val driver: WebDriver = ChromeDriver()
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.get("https://www.google.by")
    val webElement = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
    webElement.sendKeys("Selenium")
    webElement.submit()

    val searchResults: List<WebElement> = driver.findElements(By.cssSelector(".g"))
    println(searchResults.size)

    //val firstSearchLink = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div.tF2Cxc > div
    // .yuRUbf > a > h3"))
    val firstSearchLink = driver.findElement(By.xpath("//h3[text()='Selenium - Википедия']"))
    firstSearchLink.click()

    driver.quit()
  }
}