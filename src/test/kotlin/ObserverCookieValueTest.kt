import core.api.crm.controller.CrmController
import core.holder.dynamicContext.DynamicContextHolder
import core.observer.ObserverCookieValue
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class ObserverCookieValueTest: BaseTest() {

  private val authUserCookieName: String = "AuthUser"

  @Test
  fun `Verify cookie and Observer cookie AuthUser token`() {

    DynamicContextHolder.getDynamicConfig().sessionContext.serviceResponse = CrmController().authCrm()

    assertAll(
      {
        assertNotNull(
          //check cookie not null , "Cookies not received"
        )
      },
      {
        assertNotNull(
          //check the cookie is in dynamicContext , "No cookie appeared in the dynamic context"
        )
      }
    )
  }
}