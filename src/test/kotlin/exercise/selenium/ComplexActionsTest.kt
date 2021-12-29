package exercise.selenium

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions
import java.util.concurrent.TimeUnit

class ComplexActionsTest {
  companion object {
    private val driver: WebDriver = ChromeDriver()
  }

  @BeforeEach
  fun `SetDriver`() {
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
  }

  @Test
  fun `Drag Box`() {
    driver.get("https://mzabriskie.github.io/react-draggable/example/")

    val draggableBox = driver.findElement(By.xpath("//div[text()='I can be dragged anywhere']"))
    val destinationBox = driver.findElement(By.xpath("//div[text()='I can only be dragged vertically']"))

    val builder = Actions(driver)
    builder.dragAndDrop(draggableBox, destinationBox).perform()
    //builder.dragAndDropBy(draggableBox, 100, 100).perform()
  }

  @Test
  fun `Print square`() {
    driver.get("https://www.youidraw.com/apps/painter/")

    val catch = driver.findElement(By.cssSelector("#catch"))
    driver.findElement(By.cssSelector("#brush")).click()

    val builder = Actions(driver)
    builder.moveToElement(catch).clickAndHold().moveByOffset(100, 0)
      .moveByOffset(0, 100)
      .moveByOffset(-100, 0)
      .moveByOffset(0, -100)
      .release().perform()

    builder.moveToElement(catch).clickAndHold().moveByOffset(-100, 0)
      .moveByOffset(0, -100)
      .moveByOffset(100, 0)
      .moveByOffset(0, 100)
      .release().perform()
  }

//
//  @AfterEach
//  fun `CloseBrowser`(){
//    driver.quit()
//  }
}