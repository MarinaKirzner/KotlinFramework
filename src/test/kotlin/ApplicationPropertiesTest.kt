import core.`object`.TafSystemProperties
import core.provider.ApplicationConfigProvider
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ApplicationPropertiesTest {

  @Test
  fun `Authentication using SystemProperties`() {
    val expectedUser = "test1"
    val expectedPass = "test1"
    System.setProperty(TafSystemProperties.USER, expectedUser)
    System.setProperty(TafSystemProperties.PASS, expectedPass)

    val appConfig = ApplicationConfigProvider().getApplicationConfig()

    val actualUser = appConfig.user
    val actualPass = appConfig.pass

    Assertions.assertEquals(expectedUser, actualUser, "User not correct")
    Assertions.assertEquals(expectedPass, actualPass, "Pass not correct")
  }

  @AfterEach
  fun clear() {
    System.clearProperty(TafSystemProperties.USER)
    System.clearProperty(TafSystemProperties.PASS)
  }
}