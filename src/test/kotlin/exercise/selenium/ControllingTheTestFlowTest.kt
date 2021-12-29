package exercise.selenium

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class ControllingTheTestFlowTest {

  companion object {
    private val driver: WebDriver = ChromeDriver()
  }

  @BeforeEach
  fun `SetDriver`() {
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
  }

//  @Test
//  fun `Waiting for all jQuery processes to finish`(){
//
//
//    fun `Apply`(driver): Boolean {
//      val js = (JavascriptExecutor) driver
//      return
//    }
//

  @Test
  fun `New tab Open and Close`() {
    driver.get("https://the-internet.herokuapp.com/windows")

    val initialWindowHandle = driver.windowHandle
    driver.findElement(By.cssSelector(".example>a")).click()

    for (handle in driver.windowHandles) {
      driver.switchTo().window(handle)
    }

    var textWebElement = driver.findElement(By.cssSelector("body > div > h3"))
    Assertions.assertEquals(textWebElement.text, "New Window")

    driver.close()
    driver.switchTo().window(initialWindowHandle)   //для переключения окон

    textWebElement = driver.findElement(By.cssSelector("#content > div > h3"))
    Assertions.assertEquals(textWebElement.text, "Opening a new window")
  }

  @Test
  fun `Alert Test`() {
    driver.get("https://the-internet.herokuapp.com/javascript_alerts")

    driver.findElement(By.cssSelector("[onclick='jsPrompt()']")).click()
    val alert = driver.switchTo().alert()
    alert.sendKeys("Hello")
    //Assertions.assertEquals(alert.text, "You entered: I am a JS Alert")
    alert.accept()
  }

  @Test
  fun `Frame test`() {
    driver.get("https://the-internet.herokuapp.com/nested_frames")

    driver.switchTo().frame("frame-top")
    driver.switchTo().frame("frame-middle")

    val middle = driver.findElement(By.cssSelector("body"))
    Assertions.assertEquals(middle.text, "MIDDLE", "Isn't left")

    driver.switchTo().defaultContent()
    driver.switchTo().frame("frame-top")
    driver.switchTo().frame("frame-left")

    val left = driver.findElement(By.cssSelector("body"))
    Assertions.assertEquals(left.text, "LEFT", "Isn't middle")
  }

  @AfterEach
  fun `CloseBrowser`() {
    driver.quit()
  }
}