package services.db

import core.db.DbSelectData
import io.qameta.allure.Step

class IpruDatabaseOperations {

  private val clientId: String = "403"

  @Step
  fun dbSelectClientData(): Map<String, Any> {
    val clientData: MutableMap<String, Any> = DbSelectData().getDbSqlClientData(clientId) as MutableMap<String, Any>
    clientData.putAll(DbSelectData().getDbSqlClientIndividualData(clientId))
    return clientData
  }
}