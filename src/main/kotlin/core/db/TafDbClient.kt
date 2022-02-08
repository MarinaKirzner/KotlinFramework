package core.db

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import core.context.dbClientConfig

class TafDbClient : DbClient {

  private val session: Session = dbClientConfig.run { session(url, user, password) }

  override fun getClient(): Session {
    return session
  }

  override fun selectOneRow(query: SqlQuery, limitRows: Int): Map<String, Any> =
    getClient().query(
      SqlQueryBuilder().getOneRowFromClientTable(query, limitRows),
      ResultSetProvider().getOneRowData()
    )

  override fun selectAllRows(query: SqlQuery): ArrayList<HashMap<String, Any>> =
    getClient().query(
      SqlQueryBuilder().getAllRowFromClientTable(query),
      ResultSetProvider().getAllRowsData()
    )

  override fun closeDbConnection() = getClient().connection.close()
}