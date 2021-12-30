package exercise.selenium

import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import java.awt.Toolkit
import java.awt.image.PixelGrabber
import java.io.File
import java.util.*
import javax.imageio.ImageIO

class ScreenshotsTest {

  enum class Result {
    MATCH, SIZE_MISMATCH, PIXEL_MISMATCH
  }

  companion object {
    //val driver = ChromeDriver()

    fun screenFile(driver: WebDriver): File {
      val screenshotFile = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
      return screenshotFile
    }

    fun screenFile(driver: WebDriver, element: WebElement): File {
      val screenshotFile = (driver as TakesScreenshot).getScreenshotAs(OutputType.FILE)
      val img = ImageIO.read(screenshotFile)

      val width = element.size.getWidth()
      val height = element.size.getHeight()
      val point = element.location
      val screenImg = img.getSubimage(point.getX(), point.getY(), width, height)
      ImageIO.write(screenImg, "jpg", screenshotFile)

      return screenshotFile
    }

    fun compareImages(baseFile: String, actualFile: String): Result {
      var compareResult = Result.PIXEL_MISMATCH
      val baseImage = Toolkit.getDefaultToolkit().getImage(baseFile)
      val actualImage = Toolkit.getDefaultToolkit().getImage(actualFile)

      val baseImageGrab = PixelGrabber(baseImage, 0, 0, -1, -1, false)
      val actualImageGrab = PixelGrabber(actualImage, 0, 0, -1, -1, false)
      var baseImageData: Array<Any>? = null
      var actualImageData: Array<Any>? = null

      if (baseImageGrab.grabPixels()) {
        baseImageData = arrayOf(baseImageGrab.pixels as Any)
      }
      if (actualImageGrab.grabPixels()) {
        actualImageData = arrayOf(actualImageGrab.pixels as Any)
      }

      if (baseImageGrab.height != actualImageGrab.height || baseImageGrab.width != actualImageGrab.width) {
        compareResult = Result.SIZE_MISMATCH
      } else if (Arrays.equals(baseImageData, actualImageData)) {
        compareResult = Result.MATCH
      }

      return compareResult
    }
  }

//  @Test
//  fun `Screenshot window`(){
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
//    driver.manage().window().maximize()
//    driver.get("https://ru.wallpaper.mob.org/image/animals-shchenok-malish-sobaka-lezhat-pushistii-104479.html")
//
//    val image = driver.findElement(By.xpath("//div[@class='page-image__image-wrapper-inner']"))
//    Cache.copyFile(screenFile(driver, image), File("C:\\data\\image.jpg"))
//
//    driver.quit()
//  }

}