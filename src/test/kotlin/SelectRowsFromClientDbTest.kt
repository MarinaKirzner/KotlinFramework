import core.db.TafDbClient
import core.db.selectClientByContainsPartOfEmail
import core.db.selectClientByIdQuery
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SelectRowsFromClientDbTest : BaseTest() {

  private val idClient: Map<String, String> = mapOf("id" to "2")
  private val partEmailByClientDb: Map<String, String> = mapOf("partEmail" to "ta-x%", "numberEmail" to "%65%")
  private val emailColumnName: String = "email"
  private val actualEmail: String = "email@mail.com"

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
  fun `Verify customer's email from one row of table Client`() {
    val expectedEmail: String = tafDbClient
      .selectOneRow(selectClientByIdQuery, idClient).getValue(emailColumnName) as String
    Assertions.assertEquals(expectedEmail, actualEmail, "Actual email doesn't match expected")
  }

  @Test
  fun `Verify multiple entries from table Client`() {
    val expectedNumberEmail: ArrayList<Map<String, Any>> = tafDbClient
      .selectAllRows(selectClientByContainsPartOfEmail, partEmailByClientDb)
    Assertions.assertTrue(expectedNumberEmail.isNotEmpty(), "Number emails is null")
  }
}