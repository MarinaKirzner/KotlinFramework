package core.http.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.internal.toHeaderList
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class TafLoggerInterceptor : Interceptor {

  private val logger: Logger = LogManager.getLogger()

  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val response: Response = chain.proceed(request)
    logger.info(
      """
     ${"requestUrl: "}${request.url}
     ${"Header: "}${response.headers.toHeaderList().joinToString("\n")}
     ${"StatusCode: "}${response.code}
    """.trimIndent()
    )
    return response
  }
}