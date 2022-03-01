package core.db

import core.db.SqlQuery.selectClientDbDataQuery
import core.db.SqlQuery.selectClientIndividualDbDataQuery

class DbSelectClientData(private val tafDbClient: TafDbClient = TafDbClient()) {

  fun dbSqlSelectClientData(clientId: String): Map<String, Any> {
    val dbClientData: Map<String, String> = mapOf("id" to clientId)
    return tafDbClient.selectOneRow(selectClientDbDataQuery, dbClientData)
  }

  fun dbSqlSelectClientIndividualData(clientId: String): Map<String, Any> {
    val dbClientData: Map<String, String> = mapOf("id" to clientId)
    return tafDbClient.selectOneRow(selectClientIndividualDbDataQuery, dbClientData)
  }
}