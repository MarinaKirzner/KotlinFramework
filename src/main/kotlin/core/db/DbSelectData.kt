package core.db

import com.codeborne.selenide.Selenide.`$`
import org.openqa.selenium.By

class DbSelectClientData(private val tafDbClient: TafDbClient = TafDbClient(),
  clientId: String = `$`(By.tagName("h2")).text.split(" ").last()) {

  private val dbClientData: Map<String, String> = mapOf("id" to clientId)

  fun dbSelectClientDataFromRow(queryData: String): Map<String, Any> {
    val clientData: MutableMap<String, Any> = mutableMapOf()
    clientData.putAll(tafDbClient.selectOneRow(queryData, dbClientData))
    return clientData
  }
}