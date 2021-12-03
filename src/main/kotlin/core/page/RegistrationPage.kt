import core.page.BasePage

class RegistrationPage: BasePage() {

  override val url: String = "qa-delivery-es-release.moneyman.ru/client-area/#/registration?"

  fun getPageUrl(): String {
    return url
  }
}