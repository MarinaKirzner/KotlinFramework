package services.db

import core.db.DbSelectClientData
import io.qameta.allure.Step

class IpruDatabaseOperations {

  private val clientId: String = "403"

  @Step
  fun dbSelectClientData(): Map<String, Any> {
    val clientData: MutableMap<String, Any> = DbSelectClientData().dbSqlSelectClientData(clientId) as MutableMap<String, Any>
    clientData.putAll(DbSelectClientData().dbSqlSelectClientIndividualData(clientId))
    return clientData
  }
}