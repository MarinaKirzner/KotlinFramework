package exercise.selenium

import com.sun.deploy.cache.Cache
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import java.io.File
import java.util.concurrent.TimeUnit

class CanvasTest {

  companion object {
    val driver = ChromeDriver()
  }

  @Test
  fun `Compare drawings`() {
    val initialFilePath = "C:\\data\\initialFile.jpg"
    val actualFilePath = "C:\\data\\actualFile.jpg"

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.manage().window().maximize()
    driver.get("https://www.youidraw.com/apps/painter/")

    val catch = driver.findElement(By.cssSelector("#catch"))
    val canvas = driver.findElement(By.cssSelector("#brush"))
    canvas.click()

    val builder = Actions(driver)
    builder.moveToElement(catch).clickAndHold().moveByOffset(100, 0)
      .moveByOffset(0, 100)
      .moveByOffset(-100, 0)
      .moveByOffset(0, -100)
      .release().perform()

    Cache.copyFile(ScreenshotsTest.screenFile(driver), File(initialFilePath))
    Cache.copyFile(ScreenshotsTest.screenFile(driver), File(actualFilePath))

    Assertions.assertEquals(
      ScreenshotsTest.Result.PIXEL_MISMATCH,
      ScreenshotsTest.compareImages(initialFilePath, actualFilePath),
      "Compare match"
    )

    Thread.sleep(5000)
    driver.quit()
  }
}