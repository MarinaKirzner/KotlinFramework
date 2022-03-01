package services.db

import core.db.DbSelectClientData
import io.qameta.allure.Step

class IpruDatabaseOperations {

  @Step
  fun dbSelectClientData(queryMainData: String, queryOtherData: String): Map<String, Any> {
    val clientData: MutableMap<String, Any> = mutableMapOf()
    DbSelectClientData().apply {
      with(clientData) {
        putAll(dbSelectClientDataFromRow(queryMainData))
        putAll(dbSelectClientDataFromRow(queryOtherData))
      }
    }
    return clientData
  }
}