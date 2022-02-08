import core.db.TafDbClient
import core.db.queryForAllRow
import core.db.queryForOneRow
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SelectRecordsFromSqlDbTest : BaseTest() {

  private val indexRow: Int = 0
  private val limitRows: Int = 1
  private val emailColumnName: String = "email"
  private val actualEmail: String = "email@mail.com"
  private val phoneColumnName: String = "phone"
  private val actualTelephone: String = "+73331132333"

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
    val expectedEmail: String = TafDbClient().selectOneRow(queryForOneRow, limitRows).getValue(emailColumnName) as String
    Assertions.assertEquals(expectedEmail, actualEmail, "Actual email doesn't match expected")
  }

  @Test
  fun `Verify customer's phone from first row of table Client`() {
    val expectedEmail: String = TafDbClient().selectAllRows(queryForAllRow)[indexRow].getValue(phoneColumnName) as String
    Assertions.assertEquals(expectedEmail, actualTelephone, "Actual phone doesn't match expected")
  }
}