package core.db

import com.vladsch.kotlin.jdbc.Session

interface DbClient {
  fun getClient(): Session
  fun selectOneRow(query: String, parameters: Map<String, String>): Map<String, Any>
  fun selectAllRows(query: String, parameters: Map<String, String>): ArrayList<Map<String, Any>>
  fun closeDbConnection()
}