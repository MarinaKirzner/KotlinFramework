package core.db

import com.vladsch.kotlin.jdbc.Row
import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery
import core.context.dbClientConfig
import core.db.model.MemberDbConfig
import java.sql.ResultSet

class TafDbClientConfig: DbClientConfig {

  private val url: String = dbClientConfig.url
  private val user: String = dbClientConfig.user
  private val password: String = dbClientConfig.password
  private val memberDbConfig: MemberDbConfig = MemberDbConfig()

  private val session: Session = session(url, user, password)

  override fun getClient(): Session {
    return session
  }

  override fun selectOneRow(query: String): MemberDbConfig? {
    val toMember: (Row) -> MemberDbConfig = { row ->
      MemberDbConfig(
        row.string(memberDbConfig.id),
        row.string(memberDbConfig.clientType),
        row.string(memberDbConfig.email)
      )
    }
    val sqlQuery: SqlQuery = sqlQuery(query)
    return getClient().first(sqlQuery, toMember)
  }

  override fun selectAllRows(query: String): ArrayList<HashMap<String, Any>> {
    val rowsData: ArrayList<HashMap<String, Any>> = arrayListOf()
    val getMultipleRows: (ResultSet) -> ArrayList<HashMap<String, Any>> = { resultSet ->
      val md = resultSet.metaData
      val columns: Int = md.columnCount
      while (resultSet.next()) {
        val rowData: HashMap<String, Any> = hashMapOf()
        for (i in 1..columns) {
          rowData.put(md.getColumnName(i), resultSet.getObject(i))
        }
        rowsData.add(rowData)
      }
      rowsData
    }
    val sqlQuery: SqlQuery = sqlQuery(allRowDataFromDb)
    return getClient().query(sqlQuery, getMultipleRows)
  }

  override fun closeDbConnection() {
    getClient().connection.close()
  }
}