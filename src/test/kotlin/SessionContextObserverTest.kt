import core.api.crm.controller.CrmController
import core.holder.dynamicContext.DynamicContextHolder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SessionContextObserverTest : BaseTest() {

  @Test
  fun `Verify that AuthUser cookie value set in SessionContext when make CRM authorisation service call`() {
    CrmController().authCrm()
    val expectedAuthUserValue = DynamicContextHolder.getDynamicConfig().sessionContext.authUserCookieValue
    Assertions.assertNotNull(expectedAuthUserValue, "$expectedAuthUserValue doesn't set in session context")
  }
}