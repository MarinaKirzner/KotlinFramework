package exercise.selenium.yandexFactory

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class YandexPageFactoryTest {

  companion object {
    val driver = ChromeDriver()
  }

  lateinit var gmailPageFactory: YandexPageFactory
  lateinit var googleHomePageFactory: YandexHomePageFactory
  lateinit var loginInGmailFactory: LoginInYandexFactory

  @BeforeEach
  fun initPageObject() {
    gmailPageFactory = YandexPageFactory(driver)
    googleHomePageFactory = YandexHomePageFactory(driver)
    loginInGmailFactory = LoginInYandexFactory(driver)
  }

  @Test
  fun `Count the number of letters`() {
    driver.get("https://yandex.by/")
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

    googleHomePageFactory.getPageForLogin(driver)
    loginInGmailFactory.getEmailAndPass(driver)
    googleHomePageFactory.goToYandex(driver)

    Assertions.assertEquals(gmailPageFactory.getCountEmails(driver), "3", "More or less letters")
  }
}