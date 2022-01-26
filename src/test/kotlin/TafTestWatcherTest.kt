import com.codeborne.selenide.Selenide
import core.watcher.TafTestWatcher
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TafTestWatcher::class)
class TafTestWatcherTest {

  private val expectedUrl: String = "https://www.baeldung.com/"
  private val actualUrl: String = "https://www.baeldung.com/junit-testwatcher"

  @Test
  fun failResultLoggerExtension() {
    Selenide.open(actualUrl)
    Assertions.assertEquals(expectedUrl, actualUrl, "Expected url isn't actual url")
  }
}