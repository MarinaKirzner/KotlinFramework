package core.db

import java.sql.ResultSet

class ResultSetProvider {

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

  fun getAllRowsData(): (ResultSet) -> ArrayList<HashMap<String, Any>> = { resultSet ->
    val rowsData: ArrayList<HashMap<String, Any>> = arrayListOf()
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