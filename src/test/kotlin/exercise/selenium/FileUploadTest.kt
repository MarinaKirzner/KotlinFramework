package exercise.selenium

import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import java.io.File
import java.util.concurrent.TimeUnit

class FileUploadTest {

  @Test
  fun `File Upload`() {
    val driver = ChromeDriver()
    driver.get("https://the-internet.herokuapp.com/upload")
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    driver.manage().window().maximize()

    val selectFile = driver.findElement(By.id("file-upload"))
    val file = File("src/main/resources/basicAuth.exe")
    selectFile.sendKeys(file.absolutePath)

    driver.findElement(By.id("file-submit")).click()
    Thread.sleep(5000)

    driver.quit()
  }
}