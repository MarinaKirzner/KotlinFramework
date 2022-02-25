package services.db

import core.db.DbSelectClientData
import io.qameta.allure.Step

class IpruDatabaseOperations {

  @Step
  fun dbSelectClientData(queryMainData: String, queryOtherData: String, id: Map<String, String>): Map<String, Any> {
    return DbSelectClientData().dbSelectClientDataFromRow(queryMainData, queryOtherData, id)
  }
}