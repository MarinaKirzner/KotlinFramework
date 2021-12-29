package exercise.selenium

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.TimeUnit

class ParametrizedTest {

//  companion object{
//    private val driver: WebDriver = ChromeDriver()
//  }
//
//  @BeforeEach
//  fun `SetDriver`(){
//    driver.manage().window().maximize()
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
//  }

  @ParameterizedTest
  @ValueSource(strings = arrayOf("selenium", "home", "junit5"))
  fun `Parametrized Test`(writeText: String) {

    val driver: WebDriver = ChromeDriver()
    driver.manage().window().maximize()
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

    driver.get("https://www.google.by")

    val searchField =
      driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"))
    searchField.sendKeys(writeText)
    searchField.submit()

    driver.quit()
  }

//  @AfterEach
//  fun `CloseBrowser`(){
//   driver.quit()
//  }

}