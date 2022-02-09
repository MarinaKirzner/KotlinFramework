package core.db

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery
import core.context.dbClientConfig
import java.sql.ResultSet

class TafDbClient : DbClient {

  private val session: Session = dbClientConfig.run { session(url, user, password) }

  override fun getClient(): Session {
    return session
  }

  override fun selectOneRow(query: String, id: Int): Map<String, Any> {
    val sqlQuery: SqlQuery = SqlQueryBuilder().getOneClientData(query, id)
    val rowData: (ResultSet) -> Map<String, Any> = ResultSetProvider.getOneRowData()
    return getClient().query(sqlQuery, rowData)
  }

  override fun selectAllRows(query: String): ArrayList<Map<String, Any>> {
    val sqlQuery: SqlQuery = sqlQuery(query)
    val rowsData: (ResultSet) -> ArrayList<Map<String, Any>> = ResultSetProvider.getAllRowsData()
    return getClient().query(sqlQuery, rowsData)
  }

  override fun closeDbConnection() = getClient().connection.close()
}