package core.db

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.SqlQuery

interface DbClient {
  fun getClient(): Session
  fun selectOneRow(query: SqlQuery, limitRows: Int): Map<String, Any>
  fun selectAllRows(query: SqlQuery): ArrayList<HashMap<String, Any>>
  fun closeDbConnection()
}