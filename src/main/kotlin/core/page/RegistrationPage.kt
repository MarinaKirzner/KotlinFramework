import core.page.BasePage
import core.provider.ApplicationConfigProvider

class RegistrationPage : BasePage() {

  override val url: String = ApplicationConfigProvider().getUrlRegistration()

  fun getPageUrl(): String {
    return url
  }
}