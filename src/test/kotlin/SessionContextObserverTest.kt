import core.context.httpClientResponse
import core.context.sessionContext
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SessionContextObserverTest : BaseTest() {

  @Test
  fun `Verify that AuthUser cookie value set in SessionContext when make CRM authorisation service call`() {
    httpClientResponse()
    val expectedAuthUserValue = sessionContext().authUserCookieValue
    Assertions.assertNotNull(expectedAuthUserValue, "$expectedAuthUserValue doesn't set in session context")
  }
}