package services.db

import core.db.DbSelectData
import core.db.TafDbClient
import core.ui.page.CrmLeadsPage
import io.qameta.allure.Step

class IpruDatabaseOperations {

  private val dbSelectData: DbSelectData by lazy { DbSelectData() }

  @Step
  fun dbSelectClientData(clientId: String): Map<String, Any> {
    val clientData: MutableMap<String, Any> = dbSelectData.getDbSqlClientData(clientId) as MutableMap<String, Any>
    clientData.putAll(dbSelectData.getDbSqlClientIndividualData(clientId))
    return clientData
  }
}