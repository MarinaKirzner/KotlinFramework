package config.provider

import config.factory.ReadYamlConfig.Companion.logger
import config.model.Config
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import kotlin.math.log

class ConfigProviderTest {

  @ParameterizedTest(name = "Verify getConfig returns config from file {arguments}")
  @EnumSource(FormatType::class)
  fun `Verify getConfig returns config from file`(formatType: FormatType) {

    val logger: Logger = LogManager.getRootLogger()
    logger.info("Selected factory for read config file")
    logger.error("No factory selected for reading configuration file")


    val expectedObject = Config(myHost = "127.0.0.1", url = "test", login = "myemail@gmail.com", pass = "jhfloeriup")
    val actualObject: Config = ConfigProvider().getConfig(formatType)

    Assertions.assertEquals(expectedObject, actualObject, "Object doesn't match config file with type $formatType")
  }
}

