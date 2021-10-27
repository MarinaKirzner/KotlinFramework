package config.provider

import config.model.Config
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class ConfigProviderTest {

  @ParameterizedTest(name = "Verify getConfig returns config from file {arguments}")
  @EnumSource(FormatType::class)
  fun `Verify getConfig returns config from file`(formatType: FormatType) {
    val expectedObject = Config(myHost = "127.0.0.1", url = "test", login = "myemail@gmail.com", pass = "jhfloeriup")
    val actualObject: Config = ConfigProvider().getConfig(formatType)

    val expectedAnotherVariableName = expectedObject.myHost
    val actualAnotherVariableName = actualObject.myHost

    val expectedIgnoreNullableInModel = expectedObject.ignoreNullableInModel
    val actualIgnoreNullableInModel = actualObject.ignoreNullableInModel

    assertAll(
      {
        assertEquals(
          expectedObject, actualObject,
          "Object doesn't match config file with type $formatType"
        )
      },
      {
        assertEquals(
          expectedAnotherVariableName, actualAnotherVariableName,
          "The value of the variable myHost is not correctly"
        )
      },
      {
        assertEquals(
          expectedIgnoreNullableInModel, actualIgnoreNullableInModel,
          "Model-only value 'ignoreNullableInModel' isn't set NOT_DEFINED"
        )
      }
    )
  }
}


