import core.api.crm.controller.CrmController
import core.holder.dynamicContext.DynamicContextHolder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ObserverCookieValueTest : BaseTest() {

  @Test
  fun `Add observer to validate AuthUser in a dynamic context and verify AuthUser cookie is not empty`() {
    CrmController().authCrm()
    val expectedAuthUserValue = DynamicContextHolder.getDynamicConfig().sessionContext.authUserValue
    Assertions.assertNotNull(expectedAuthUserValue, "${expectedAuthUserValue} contains no data")
  }
}