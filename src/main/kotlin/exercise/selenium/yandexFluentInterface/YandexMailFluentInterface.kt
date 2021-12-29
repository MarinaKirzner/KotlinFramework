package exercise.selenium.yandexFluentInterface

import org.junit.jupiter.api.Assertions
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class YandexMailFluentInterface() {

  companion object {
    val driver = ChromeDriver()
  }

  val star = By.xpath("//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']")

  fun assertNumbersOfEmail(numbers: Int): YandexMailFluentInterface {
    Assertions.assertEquals(listOf(driver.findElements(star)).size, numbers, "More or less letters")
    return this
  }
}