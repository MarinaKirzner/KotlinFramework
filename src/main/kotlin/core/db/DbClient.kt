package core.db

import com.vladsch.kotlin.jdbc.Session

interface DbClient {
  fun getClient(): Session
  fun selectOneRow(query: String, id: Int): Map<String, Any>
  fun selectAllRows(query: String): ArrayList<Map<String, Any>>
  fun closeDbConnection()
}