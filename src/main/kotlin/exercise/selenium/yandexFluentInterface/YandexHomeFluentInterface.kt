package exercise.selenium.yandexFluentInterface

import exercise.selenium.yandexFluentInterface.YandexMailFluentInterface.Companion.driver
import org.openqa.selenium.By

class YandexHomeFluentInterface() {

  val loginPage = By.xpath("//div[text()='Войти']")
  val toGmail = By.xpath("//div[text()='Почта']")

  fun getPageForLogin(): LoginYandexFluentInterface {
    driver.findElement(loginPage).click()
    return LoginYandexFluentInterface()
  }

  fun goToYandex(): YandexMailFluentInterface {
    driver.findElement(toGmail).click()
    return YandexMailFluentInterface()
  }
}