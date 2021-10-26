package config.provider

import config.model.Config
import enum.FormatType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class ConfigProviderTest {

  @ParameterizedTest(name = "Read of the {arguments}-file into an object")
  @EnumSource(FormatType::class)
  fun `Verify to read the configuration file into an object`(formatType: FormatType) {
    val expectedYaml = Config(url = "test", login = "myemail@gmail.com", pass = "jhfloeriup")
    val actualYaml: Config = ConfigProvider().getConfig(formatType)
    Assertions.assertEquals(expectedYaml, actualYaml, "Object doesn't match config file with type $formatType")
  }
}