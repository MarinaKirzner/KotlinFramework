package selenium.gmail

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class GmailPage {
  fun getCountEmails(driver: ChromeDriver): Int {
    val numbers = listOf(driver.findElements(By.cssSelector("#\\:jg > td.apU.xY"))).size
    return numbers
  }
}