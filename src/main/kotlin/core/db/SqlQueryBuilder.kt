package core.db

import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.sqlQuery

class SqlQueryBuilder {

  fun getOneClientData(query: String, id: Int): SqlQuery {
    return sqlQuery(query, mapOf("id" to id))
  }
}