package selenium.gmail

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class GoogleHomePage {

  fun getPageForLogin(driver: ChromeDriver) {
    driver.findElement(By.cssSelector("#gb>div>div.gb_Me>a")).click()
  }

  fun goToGmail(driver: ChromeDriver){
    driver.findElement(By.cssSelector("[href='https://mail.google.com/mail/&ogbl']")).click()
  }
}