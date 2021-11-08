package selenium.gmail

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class LoginInGmail {
  fun getEmailAndPass(driver: ChromeDriver) {
    driver.findElement(By.cssSelector("input[type='email']")).sendKeys("comaqa.conference")
    driver.findElement(By.id("identifierNext")).click()
    driver.findElement(By.cssSelector("")).sendKeys("ComaqaP@$\$word")
    driver.findElement(By.id("passwordNext")).click()
  }
}