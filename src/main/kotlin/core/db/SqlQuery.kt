package core.db

import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.sqlQuery

val queryForOneRow: SqlQuery = sqlQuery("select * from mrt.client limit ?")
val queryForAllRow: SqlQuery = sqlQuery("select * from mrt.client")