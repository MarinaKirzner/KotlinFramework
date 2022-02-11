package core.db

import com.vladsch.kotlin.jdbc.Session

interface DbClient {
  fun getClient(): Session?
  fun selectOneRow(query: String, parameters: Map<String, String> = mapOf()): Map<String, Any>
  fun selectAllRows(query: String, parameters: Map<String, String> = mapOf()): ArrayList<Map<String, Any>>
  fun closeDbConnection()
}