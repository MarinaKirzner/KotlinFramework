//package exercise.selenium.projectArchitecture.fluentInterfaceCore
//
//import exercise.selenium.projectArchitecture.core.Locator.Companion.getLocator
//import exercise.selenium.projectArchitecture.core.PageBase
//import exercise.selenium.projectArchitecture.core.WebDriverContainer.Companion.findElement
//import exercise.selenium.projectArchitecture.helpers.Waiter
//
//class YandexHomeCore(): PageBase() {
//
//  companion object {
//    val loginPage = getLocator("YandexHomeCore.loginPage")
//    val toGmail = getLocator("YandexHomeCore.toGmail")
//    val TITLE = "Yandex Mail title"
//  }
//    fun getPageForLogin() {
//      findElement(loginPage)?.click()
//    }
//
//    fun goToYandex() {
//      findElement(toGmail)?.click()
//      Waiter().waitForJquery()
//    }
//
//  fun assertTitle() {
//    assertTitle(TITLE)
//  }
//
//}