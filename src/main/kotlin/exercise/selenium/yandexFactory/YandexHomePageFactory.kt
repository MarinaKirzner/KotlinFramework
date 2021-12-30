package exercise.selenium.yandexFactory

import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class YandexHomePageFactory(driver: ChromeDriver) {

  init {
    PageFactory.initElements(driver, this)
  }

  @FindBy(xpath = "//div[text()='Войти']")
  lateinit var btnLogin: WebElement

  @FindBy(xpath = "//div[text()='Почта']")
  lateinit var lnkGoToGmail: WebElement

  fun getPageForLogin(driver: ChromeDriver) {
    btnLogin.click()
  }

  fun goToYandex(driver: ChromeDriver) {
    lnkGoToGmail.click()
  }
}


