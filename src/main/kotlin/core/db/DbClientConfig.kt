package core.db

import com.vladsch.kotlin.jdbc.Session
import core.db.model.MemberDbConfig

interface DbClientConfig {
  fun getClient(): Session
  fun selectOneRow(query: String): MemberDbConfig?
  fun selectAllRows(query: String): ArrayList<HashMap<String, Any>>
  fun closeDbConnection()
}