package exercise.config.provider

import exercise.config.model.Config
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ConfigProviderSystemPropertiesTest {

  companion object {
    private const val FORMAT_TYPE_SYSTEM_PROPERTY = "FILE_SYSTEM_PROPERTY"
  }

  @BeforeEach
  fun setSystemProperties() {
    System.setProperty(FORMAT_TYPE_SYSTEM_PROPERTY, FormatType.JSON.name)
  }

  @Test
  fun `Verify getConfig returns config from file`() {
    val expectedObject = Config(myHost = "127.0.0.1", url = "test", login = "myemail@gmail.com", pass = "jhfloeriup")
    val formatSystemProperty: String = System.getProperty(FORMAT_TYPE_SYSTEM_PROPERTY)
    val actualObject: Config = ConfigProvider().getConfig(FormatType.valueOf(formatSystemProperty))

    Assertions.assertEquals(
      expectedObject,
      actualObject,
      "Object doesn't match exercise.config file with type $formatSystemProperty"
    )
  }

  @AfterEach
  fun deleteSystemProperties() {
    System.clearProperty(FORMAT_TYPE_SYSTEM_PROPERTY)
  }
}