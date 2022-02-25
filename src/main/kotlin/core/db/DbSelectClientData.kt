package core.db

class DbSelectClientData {
  private val tafDbClient: TafDbClient = TafDbClient()

  fun dbSelectClientDataFromRow(queryMainData: String, queryOtherData: String, id: Map<String, String>): Map<String, Any> {
    val clientData: MutableMap<String, Any> = mutableMapOf()
    tafDbClient.apply {
      with(clientData) {
        putAll(selectOneRow(queryMainData, id))
        putAll(selectOneRow(queryOtherData, id))
      }
    }
    return clientData
  }
}