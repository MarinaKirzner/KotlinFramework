import com.codeborne.selenide.Selenide
import core.watchers.StopTest
import core.watchers.TafTestExecutionCondition
import core.watchers.TafTestWatcher
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TafTestWatcher::class, TafTestExecutionCondition::class)
class TafTestWatcherTest {

  private val expectedUrl: String = "https://www.baeldung.com/"
  private val actualUrl: String = "https://www.baeldung.com/junit-testwatcher"

  @StopTest
  @Test
  fun `Make screenshot for failed test and add this to Allure`() {
    Selenide.open(actualUrl)
    Assertions.assertEquals(expectedUrl, actualUrl, "Expected url isn't actual url")
  }
}