package core.db

import core.db.SqlQuery.selectClientDbDataQuery
import core.db.SqlQuery.selectClientIndividualDbDataQuery

class DbSelectData(private val tafDbClient: TafDbClient = TafDbClient()) {

  fun getDbSqlClientData(clientId: String): Map<String, Any> {
    val queryParameters: Map<String, String> = mapOf("id" to clientId)
    return tafDbClient.selectOneRow(selectClientDbDataQuery, queryParameters)
  }

  fun getDbSqlClientIndividualData(clientId: String): Map<String, Any> {
    val queryParameters: Map<String, String> = mapOf("id" to clientId)
    return tafDbClient.selectOneRow(selectClientIndividualDbDataQuery, queryParameters)
  }
}