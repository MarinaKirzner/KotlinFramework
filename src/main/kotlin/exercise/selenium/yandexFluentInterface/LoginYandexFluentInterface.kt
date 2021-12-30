package exercise.selenium.yandexFluentInterface

import exercise.selenium.yandexFluentInterface.YandexMailFluentInterface.Companion.driver
import org.openqa.selenium.By

class LoginYandexFluentInterface() {

  companion object {
    val login = By.cssSelector("#passp-field-login")
    val loginNext = By.cssSelector("#passp\\:sign-in")
    val pass = By.cssSelector("#passp-field-passwd")
    val passNext = By.cssSelector("#passp\\:sign-in")
  }

  fun getEmailAndPass(): YandexHomeFluentInterface {
    driver.findElement(login).sendKeys("savvinaolia.job")
    driver.findElement(loginNext).click()
    driver.findElement(pass).sendKeys("sv123456789")
    driver.findElement(passNext).click()
    return YandexHomeFluentInterface()
  }
}