package exercise.selenium.yandexFactory

import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LoginInYandexFactory(driver: ChromeDriver) {

  init {
    PageFactory.initElements(driver, this)
  }

  @FindBy(css = "#passp-field-login")
  lateinit var login: WebElement

  @FindBy(css = "#passp\\:sign-in")
  lateinit var btnNextForPass: WebElement

  @FindBy(css = "#passp-field-passwd")
  lateinit var pass: WebElement

  @FindBy(css = "#passp\\:sign-in")
  lateinit var btnAfterPassNext: WebElement

  fun getEmailAndPass(driver: ChromeDriver) {
    login.sendKeys("savvinaolia.job")
    btnNextForPass.click()
    pass.sendKeys("sv123456789")
    btnAfterPassNext.click()
  }
}