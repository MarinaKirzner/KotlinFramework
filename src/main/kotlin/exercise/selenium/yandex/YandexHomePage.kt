package exercise.selenium.yandex

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class YandexHomePage {

  fun getPageForLogin(driver: ChromeDriver) {
    driver.findElement(By.xpath("//div[text()='Войти']")).click()
  }

  fun goToYandex(driver: ChromeDriver) {
    driver.findElement(By.xpath("//div[text()='Почта']")).click()
  }
}