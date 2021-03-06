package core.db

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import core.context.dbConnectionConfig
import java.sql.ResultSet

class TafDbClient : DbClient {

  private var session: Session? = null

  override fun getClient(): Session {
    if (session == null) {
      session = dbConnectionConfig.run { session(url, user, password) }
    }
    return session!!
  }

  override fun selectOneRow(query: String, parameters: Map<String, String>): Map<String, Any> {
    val sqlQuery: SqlQuery = SqlQueryBuilder().buildParametersForSqlQuery(query, parameters)
    val rowData: (ResultSet) -> Map<String, Any> = ResultSetProvider.getOneRowData()
    return getClient().query(sqlQuery, rowData)
  }

  override fun selectAllRows(query: String, parameters: Map<String, String>): ArrayList<Map<String, Any>> {
    val sqlQuery: SqlQuery = SqlQueryBuilder().buildParametersForSqlQuery(query, parameters)
    val rowsData: (ResultSet) -> ArrayList<Map<String, Any>> = ResultSetProvider.getAllRowsData()
    return getClient().query(sqlQuery, rowsData)
  }

  override fun closeDbConnection() {
    getClient().connection.close()
    session = null
  }
}