//package exercise.selenium.htmlElements
//
//import org.openqa.exercise.selenium.chrome.ChromeDriver
//import org.openqa.exercise.selenium.support.FindBy
//import org.openqa.exercise.selenium.support.PageFactory
//import ru.yandex.qatools.htmlelements.annotations.Name
//import ru.yandex.qatools.htmlelements.element.Button
//import ru.yandex.qatools.htmlelements.element.HtmlElement
//import ru.yandex.qatools.htmlelements.element.TextInput
//import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator
//import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory
//
//class SearchInMail(driver: ChromeDriver): HtmlElement() {
//
//  init {
//    PageFactory.initElements(HtmlElementDecorator(HtmlElementLocatorFactory(driver)), this)
//  }
//
//  @Name("Search email in Yandex Mail")
//  @FindBy(xpath = "//input[@placeholder='Поиск']")
//  lateinit var requestInput: TextInput
//
//  @Name("Search button")
//  @FindBy(xpath = "//div[@class='search-input__right-buttons']")
//  lateinit var btnSearch: Button
//
//  fun yandexSearchText(request: String) {
//    requestInput.clear()
//    requestInput.sendKeys(request)
//    btnSearch.click()
//  }
//}