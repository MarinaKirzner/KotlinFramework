package exercise.selenium.yandex

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class YandexPage {
  fun getCountEmails(driver: ChromeDriver): Int {
    val numbers =
      listOf(driver.findElements(By.xpath("//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']"))).size
    return numbers
  }
}