package exercise.selenium.yandexFluentInterface

import exercise.selenium.yandexFluentInterface.YandexMailFluentInterface.Companion.driver
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

class YandexMailFluentInterfaceTest {

  @Test
  fun `Count the number of letters`() {
    driver.get("https://yandex.by/")
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

    YandexHomeFluentInterface().getPageForLogin().getEmailAndPass().goToYandex().assertNumbersOfEmail(3)
  }
}