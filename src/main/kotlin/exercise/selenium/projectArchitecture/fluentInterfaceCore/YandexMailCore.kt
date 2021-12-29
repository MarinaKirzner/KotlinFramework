//package exercise.selenium.projectArchitecture.fluentInterfaceCore
//
//import org.junit.jupiter.api.Assertions
//import exercise.selenium.projectArchitecture.core.Locator.Companion.getLocator
//import exercise.selenium.projectArchitecture.core.PageBase
//import exercise.selenium.projectArchitecture.core.WebDriverContainer.Companion.findElements
//
//class YandexMailCore() {
//
//  companion object{
//    val star = getLocator("YandexMailCore.star")
//  }
//
//  fun assertNumbersOfEmail(numbers: Int) {
//    Assertions.assertEquals(listOf(findElements(star)).size, numbers, "More or less letters")
//  }
//}