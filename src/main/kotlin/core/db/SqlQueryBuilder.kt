package core.db

import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.sqlQuery

class SqlQueryBuilder {

  fun getOneClientData(query: String, parameter: Map<String, String>): SqlQuery {
    return sqlQuery(query, parameter)
  }
}