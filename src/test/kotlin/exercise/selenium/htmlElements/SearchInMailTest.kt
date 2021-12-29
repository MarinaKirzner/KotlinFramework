//package exercise.selenium.htmlElements
//
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.openqa.exercise.selenium.chrome.ChromeDriver
//import java.util.concurrent.TimeUnit
//
//class SearchInMailTest {
//
//  companion object {
//    val driver = ChromeDriver()
//  }
//
//  lateinit var searchInMail: SearchInMail
//
//  @BeforeEach
//  fun initPageObject() {
//    searchInMail = SearchInMail(driver)
//  }
//
//  @Test
//  fun `Search email in Yandex Mail`() {
//    driver.get("https://mail.yandex.by/?uid=1512461749#tabs/relevant")
//    driver.manage().window().maximize()
//    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
//
//    searchInMail.yandexSearchText("test")
//  }
//}
