package config.provider

import config.model.Config
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ConfigProviderSystemPropertiesTest {

  companion object {
    private const val FORMAT_TYPE_SYSTEM_PROPERTIES = "FILE_SYSTEM_PROPERTIES"
  }

  @BeforeEach
  fun setSystemProperties() {
    System.setProperty(FORMAT_TYPE_SYSTEM_PROPERTIES, FormatType.JSON.name)
  }

  @Test
  fun `Verify getConfig returns config from file`() {
    val expectedObject = Config(myHost = "127.0.0.1", url = "test", login = "myemail@gmail.com", pass = "jhfloeriup")
    val formatSystemProperties: String = System.getProperty(FORMAT_TYPE_SYSTEM_PROPERTIES)
    val actualObject: Config = ConfigProvider().getConfig(FormatType.valueOf(formatSystemProperties))

    Assertions.assertEquals(
      expectedObject,
      actualObject,
      "Object doesn't match config file with type $formatSystemProperties"
    )
  }

  @AfterEach
  fun deleteSystemProperties() {
    System.clearProperty(FORMAT_TYPE_SYSTEM_PROPERTIES)
  }
}