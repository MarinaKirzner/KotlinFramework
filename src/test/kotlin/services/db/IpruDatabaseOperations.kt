package services.db

import core.db.DbSelectData
import core.db.TafDbClient
import io.qameta.allure.Step

class IpruDatabaseOperations {

  @Step
  fun dbSelectClientData(clientId: String, tafDbClient: TafDbClient): Map<String, Any> {
    val clientData: MutableMap<String, Any> = DbSelectData(tafDbClient).getDbSqlClientData(clientId) as MutableMap<String, Any>
    clientData.putAll(DbSelectData().getDbSqlClientIndividualData(clientId))
    return clientData
  }
}