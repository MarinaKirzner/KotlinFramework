package exercise.selenium.yandexFactory

import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.FindAll
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class YandexPageFactory(driver: ChromeDriver) {

  init {
    PageFactory.initElements(driver, this)
  }

  @FindAll(FindBy(xpath = "//span[@class='_nb-checkbox-flag _nb-checkbox-normal-flag']"))
  lateinit var star: WebElement

  fun getCountEmails(driver: ChromeDriver): Int {
    val numbers = listOf(star).size
    return numbers
  }
}