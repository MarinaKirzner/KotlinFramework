package core.db

import com.vladsch.kotlin.jdbc.SqlQuery

class SqlQueryBuilder {

  fun getOneRowFromClientTable(query: SqlQuery, limitRows: Int): SqlQuery = query.params(limitRows)

  fun getAllRowFromClientTable(query: SqlQuery): SqlQuery = query
}