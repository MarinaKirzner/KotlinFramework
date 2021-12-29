//package exercise.selenium.projectArchitecture.fluentInterfaceCore
//
//import org.openqa.exercise.selenium.By
//import exercise.selenium.projectArchitecture.core.Locator.Companion.getLocator
//import exercise.selenium.projectArchitecture.core.WebDriverContainer
//import exercise.selenium.projectArchitecture.core.WebDriverContainer.Companion.findElement
//import exercise.selenium.projectArchitecture.core.WebDriverContainer.Companion.getWebDriver
//
////import exercise.selenium.yandexFluentInterface.YandexMailFluentInterface.Companion.driver
//
//class LoginYandexCore() {
//
//  companion object{
//    val login = getLocator("LoginYandexCore.login")
//    val loginNext = getLocator("LoginYandexCore.loginNext")
//    val pass = getLocator("LoginYandexCore.pass")
//    val passNext = getLocator("LoginYandexCore.passNext")
//  }
//
//  fun getEmailAndPass() {
//    findElement(login)?.sendKeys("savvinaolia.job")
//    findElement(loginNext)?.click()
//    findElement(pass)?.sendKeys("sv123456789")
//    findElement(passNext)?.click()
//  }
//}