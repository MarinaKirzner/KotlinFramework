//package exercise.selenium.core.projectArchitecture.fluentInterfaceCore
//
//import org.junit.jupiter.api.Test
//import org.openqa.exercise.selenium.By
//import org.openqa.exercise.selenium.Platform
//import org.openqa.exercise.selenium.WebDriver
//import org.openqa.exercise.selenium.chrome.ChromeOptions
//import org.openqa.exercise.selenium.firefox.FirefoxOptions
//import org.openqa.exercise.selenium.remote.DesiredCapabilities
//import org.openqa.exercise.selenium.remote.RemoteWebDriver
//import exercise.selenium.projectArchitecture.core.TestBase
//import exercise.selenium.projectArchitecture.fluentInterfaceCore.LoginYandexCore
//import exercise.selenium.projectArchitecture.fluentInterfaceCore.YandexHomeCore
//import exercise.selenium.projectArchitecture.fluentInterfaceCore.YandexMailCore
//import java.net.URL
//import java.util.concurrent.TimeUnit
//
//class YandexMailCoreTest {    //to perform the 1st test add ": TestBase()"
//
//  @Test
//  fun `Count the number of letters`() {
//    YandexHomeCore().getPageForLogin()
//    LoginYandexCore().getEmailAndPass()
//    //YandexHomeCore().assertTitle()
//    YandexHomeCore().goToYandex()
//    YandexMailCore().assertNumbersOfEmail(3)
//  }
//
//  @Test
//  fun `Selenium Grid Test`(){
//    val chromeOptions = ChromeOptions()
//    val driver: WebDriver = RemoteWebDriver(URL("http://localhost:4444/"), chromeOptions)
//    driver.get("http://www.google.com")
//    driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("hello")
//    Thread.sleep(3000)
//  }
//}