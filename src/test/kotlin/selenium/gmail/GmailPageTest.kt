package selenium.gmail

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class GmailPageTest {

  companion object{
    val driver = ChromeDriver()
  }

  @Test
  fun `Count the number of letters`() {
    driver.get("https://www.google.by")
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

    GoogleHomePage().getPageForLogin(driver)
    LoginInGmail().getEmailAndPass(driver)
    GoogleHomePage().goToGmail(driver)

    Assertions.assertEquals(GmailPage().getCountEmails(driver), "5", "More or less letters")

  }
}