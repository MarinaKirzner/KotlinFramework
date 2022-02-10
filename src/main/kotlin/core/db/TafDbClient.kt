package core.db

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import core.context.dbClientConfig
import java.sql.ResultSet

class TafDbClient : DbClient {

  private var session: Session? = null

  override fun getClient(): Session {
    return session.let {
      dbClientConfig.run { session(url, user, password) }
    }
  }

  override fun selectOneRow(query: String, parameters: Map<String, String>): Map<String, Any> {
    val sqlQuery: SqlQuery = SqlQueryBuilder().getOneClientData(query, parameters)
    val rowData: (ResultSet) -> Map<String, Any> = ResultSetProvider.getOneRowData()
    return getClient().query(sqlQuery, rowData)
  }

  override fun selectAllRows(query: String, parameters: Map<String, String>): ArrayList<Map<String, Any>> {
    val sqlQuery: SqlQuery = SqlQueryBuilder().getOneClientData(query, parameters)
    val rowsData: (ResultSet) -> ArrayList<Map<String, Any>> = ResultSetProvider.getAllRowsData()
    return getClient().query(sqlQuery, rowsData)
  }

  override fun closeDbConnection() {
    session = null
  }
}