import core.`object`.TafSystemProperties
import core.provider.ApplicationConfigProvider
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationPropertiesTest {

  @Test
  fun `Verify configuration provider uses system properties`() {
    val expectedUser = "test1"
    val expectedPass = "test1"
    System.setProperty(TafSystemProperties.USER, expectedUser)
    System.setProperty(TafSystemProperties.PASS, expectedPass)
    val appConfig = ApplicationConfigProvider().getApplicationConfig()
    val actualUser = appConfig.user
    val actualPass = appConfig.pass
    Assertions.assertEquals(expectedUser, actualUser, "Expected user $expectedUser doesn't match actual $actualUser")
    Assertions.assertEquals(expectedPass, actualPass, "Expected pass $expectedPass doesn't match actual $actualPass")
  }

  @AfterEach
  fun clear() {
    System.clearProperty(TafSystemProperties.USER)
    System.clearProperty(TafSystemProperties.PASS)
  }
}