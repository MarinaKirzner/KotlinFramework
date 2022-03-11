import core.db.SqlQuery.selectClientByContainsPartOfEmail
import core.db.SqlQuery.selectClientByIdQuery
import core.db.TafDbClient
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SelectRecordsFromClientDbTest : BaseTest() {

  private lateinit var tafDbClient: TafDbClient

  @BeforeEach
  fun sessionOpen() {
    tafDbClient = TafDbClient()
  }

  @AfterEach
  fun sessionClose() {
    tafDbClient.closeDbConnection()
  }

  @Test
  fun `Verify selectOneRow returns single record from client table by email name`() {
    val idClient: Map<String, String> = mapOf("id" to "2")
    val emailColumnName = "email"
    val actualEmail = "email@mail.com"
    val selectEmail: Map<String, Any> = tafDbClient.selectOneRow(selectClientByIdQuery, idClient)
    val expectedEmail: String = selectEmail.getValue(emailColumnName) as String
    Assertions.assertEquals(expectedEmail, actualEmail, "Actual email doesn't match expected")
  }

  @Test
  fun `Verify selectAllRow returns multiple records from client table by email options`() {
    val partEmailByClientDb: Map<String, String> = mapOf("partEmail" to "ta-x%", "emailContainsNumber" to "%64%")
    val expectedNumberEmail: ArrayList<Map<String, Any>> = tafDbClient
      .selectAllRows(selectClientByContainsPartOfEmail, partEmailByClientDb)
    Assertions.assertTrue(expectedNumberEmail.size>1, "Counts emails is one or null")
  }
}