package exercise.selenium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class VideoTest {

  companion object {
    val driver = ChromeDriver()
  }

  @Test
  fun `Video Test`() {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.manage().window().maximize()
    driver.get("https://www.w3schools.com/html/html5_video.asp")

    val videoPlayer = driver.findElement(By.id("video1"))

    val js = driver as JavascriptExecutor
    val source = js.executeScript("return arguments[0].currentSrc;", videoPlayer) as String

    println(source)
    val duration = js.executeScript("return arguments[0].duration", videoPlayer) as Double

    Assertions.assertEquals(source, "https://www.w3schools.com/html/mov_bbb.mp4")
    Assertions.assertEquals(duration.toInt(), 10)

    js.executeScript("arguments[0].play()", videoPlayer)
    Thread.sleep(3000)

    js.executeScript("arguments[0].pause()", videoPlayer)
    Thread.sleep(2000)

    driver.quit()
  }
}