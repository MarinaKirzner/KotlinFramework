package config.provider

import config.model.Config
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class ConfigProviderTest {

  @ParameterizedTest(name = "Verify getConfig returns config from file {arguments}")
  @EnumSource(FormatType::class)
  fun `Verify getConfig returns config from file`(formatType: FormatType) {
    val expectedObject = Config(myHost = "127.0.0.1", url = "test", login = "myemail@gmail.com", pass = "jhfloeriup")
    val actualObject: Config = ConfigProvider().getConfig(formatType)

    Assertions.assertEquals(expectedObject, actualObject, "Object doesn't match config file with type $formatType")
  }
}

