package exercise.selenium.yandex

import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class LoginInYandex {
  fun getEmailAndPass(driver: ChromeDriver) {
    driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("savvinaolia.job")
    driver.findElement(By.cssSelector("#passp\\:sign-in")).click()
    driver.findElement(By.cssSelector("#passp-field-passwd")).sendKeys("sv123456789")
    driver.findElement(By.cssSelector("#passp\\:sign-in")).click()
  }
}