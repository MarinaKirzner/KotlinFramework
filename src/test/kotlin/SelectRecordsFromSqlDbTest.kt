import core.db.TafDbClientConfig
import core.db.allRowDataFromDb
import core.db.oneRowDataFromDb
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SelectRecordsFromSqlDbTest : BaseTest() {

  private val actualEmail: String = "ta-yXDkhAoDeF-4378379556@mrt.ru"
  private val actualCountRow = 3

  @BeforeEach
  fun sessionOpen() {
    TafDbClientConfig().getClient()
  }

  @Test
  fun `Verify client email with one entry from user account table`() {
    val expectedEmail: String? = TafDbClientConfig().selectOneRow(oneRowDataFromDb)?.email
    Assertions.assertEquals(expectedEmail, actualEmail, "Actual email doesn't match expected")
  }

  @Test
  fun `Verify the number of output rows from the user account table`() {
    val expectedCountRow: Int = TafDbClientConfig().selectAllRows(allRowDataFromDb).size
    Assertions.assertEquals(expectedCountRow, actualCountRow, "Actual number of rows doesn't match expected")
  }

  @AfterEach
  fun sessionClose() {
    TafDbClientConfig().closeDbConnection()
  }
}