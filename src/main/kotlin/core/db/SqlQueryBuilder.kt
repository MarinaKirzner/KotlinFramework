package core.db

import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.sqlQuery

class SqlQueryBuilder {

  fun sqlQueryBuilder(query: String, parameters: Map<String, String>?): SqlQuery {
    if (parameters.isNullOrEmpty()) {
      return sqlQuery(query)
    }
    return sqlQuery(query,parameters)
  }
}