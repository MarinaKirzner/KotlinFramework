package exercise.db.member

import core.db.TafDbClient

import com.vladsch.kotlin.jdbc.Row
import com.vladsch.kotlin.jdbc.SqlQuery
import com.vladsch.kotlin.jdbc.sqlQuery

class ClientDbService {
private val ipruClientDBConfig: IpruClientDbConfig = IpruClientDbConfig()

  fun selectOneRow(query: String): IpruClientDbConfig? {
    val toMember: (Row) -> IpruClientDbConfig = { row ->
      IpruClientDbConfig(
        row.run {
          string(ipruClientDBConfig.id)
          string(ipruClientDBConfig.clientType)
          string(ipruClientDBConfig.email)
        }
      )
    }
    val sqlQuery: SqlQuery = sqlQuery(query)
    return TafDbClient().getClient().first(sqlQuery, toMember)
  }
}