package exercise.selenium

import org.junit.jupiter.api.Test
import org.openqa.selenium.Proxy
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.firefox.FirefoxDriver
import java.io.File
import java.util.concurrent.TimeUnit

class BasicAuthentication {

  companion object {
    val username = "admin"
    val pass = "admin"
  }

  @Test
  fun `Basic authentication`() {
    val driver = ChromeDriver()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.manage().window().maximize()

    driver.get("https://" + username + ":" + pass + "@the-internet.herokuapp.com/basic_auth")

    Thread.sleep(3000)
    driver.quit()
  }

  @Test
  fun `Basic authentication through a proxy`() {
    val proxy = Proxy()
    proxy.setHttpProxy("5556")
//    proxy.setSocksUsername(username)
//    proxy.setSocksPassword(pass)

//    setDefault(PasswordAuthentication(username, pass.toCharArray()))
//    PasswordAuthentication(username, pass.toCharArray())
//    driver.get("https://" + username +":" + pass + "@the-internet.herokuapp.com/basic_auth")

    val options = ChromeOptions()
    options.setCapability("proxy", proxy)
    val driver: WebDriver = ChromeDriver(options)
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.manage().window().maximize()

    driver.get("https://the-internet.herokuapp.com/basic_auth")
    Thread.sleep(3000)
    driver.quit()
  }

  @Test
  fun `Basic authentication AutoIt`() {
    val fileAutoItScript = File("src/main/resources/basicAuth.exe")
    val driver = FirefoxDriver()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.manage().window().maximize()

    driver.get("https://the-internet.herokuapp.com/basic_auth")
    Runtime.getRuntime().exec(fileAutoItScript.absolutePath + " " + username + " " + pass)
    Thread.sleep(5000)
    driver.quit()
  }
}
