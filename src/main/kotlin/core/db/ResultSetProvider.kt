package core.db

import java.sql.ResultSet

object ResultSetProvider {

  fun getOneRowData(): (ResultSet) -> Map<String, Any> = { resultSet ->
    val rowData: HashMap<String, Any> = hashMapOf()
    val md = resultSet.metaData
    val columns: Int = md.columnCount
    while (resultSet.next()) {
      for (i in 1..columns) {
        rowData.put(md.getColumnName(i), resultSet.getObject(i))
      }
    }
    rowData
  }

  fun getAllRowsData(): (ResultSet) -> ArrayList<Map<String, Any>> = { resultSet ->
    val rowsData: ArrayList<Map<String, Any>> = arrayListOf()
    val md = resultSet.metaData
    val columns: Int = md.columnCount
    while (resultSet.next()) {
      val rowData: HashMap<String, Any> = hashMapOf()
      for (i in 1..columns) {
        rowData.put(md.getColumnName(i), resultSet.getObject(i))
      }
      rowsData.add(rowData)
    }
    rowsData
  }
}