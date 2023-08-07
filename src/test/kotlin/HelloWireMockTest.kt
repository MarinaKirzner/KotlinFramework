import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import org.junit.jupiter.api.Test

class HelloWireMockTest {

  @Test
  fun `Hello WireMock Test`() {

    WireMockServer(WireMockConfiguration.options().port(4442)
      .withRootDirectory("src/test/resources/wiremock")).stubFor(
      post(urlEqualTo("http://localhost:4442/some/thing"))
        .willReturn(
          aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "text/plain")
            .withBody("Hello world!!!!")
        )
    )
  }
}