package services.db

import core.db.DbSelectData
import io.qameta.allure.Step

class IpruDatabaseOperations {

  @Step
  fun dbSelectClientData(clientId: String): Map<String, Any> {
    val clientData: MutableMap<String, Any> = DbSelectData().getDbSqlClientData(clientId) as MutableMap<String, Any>
    clientData.putAll(DbSelectData().getDbSqlClientIndividualData(clientId))
    return clientData
  }
}