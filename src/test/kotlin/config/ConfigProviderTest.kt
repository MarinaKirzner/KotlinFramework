package config

import data_class.ConfigFile
import enum.FormatType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class ConfigProviderTest {

  @ParameterizedTest(name = "Verify to read of the {arguments}")
  @EnumSource(FormatType::class)
  fun `Verify to read the configuration file into an object`(formatType: FormatType) {
    val expectedYaml = ConfigFile(url = "test", login = "myemail@gmail.com", pass = "jhfloeriup")
    val actualYaml: ConfigFile = ConfigProvider().getConfig(formatType)
    Assertions.assertEquals(expectedYaml, actualYaml, "Object doesn't match config file")
  }
}