package core.ui.crm.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import core.ui.crm.ClientType

@JsonIgnoreProperties(ignoreUnknown = true)
data class ClientDetailsConfig(
  val clientType: String? = ClientType.INDIVIDUAL.name,
  val nickname: String? = null,
  val resident: Boolean? = null,
  val identificationNumber: String? = null,
  val surname: String? = null,
  val name: String? = null,
  val middleName: String? = null,
  val fullNameChanged: String? = null,
  val previousSurname: String? = null,
  val previousName: String? = null,
  val previousMiddleName: String? = null,
  val insuranceNumber: String? = null
) {
  companion object {
    fun convertToResidentBooleanValue(value: String): Boolean {
      return value == "Да"
    }

    fun convertToFullNameChangedValue(value: String): String {
      return if (value == "Да") "1"
      else "0"
    }

    fun convertInsuranceNumber(value: String): String? {
      return if (value == "-") null
      else "-"
    }
  }
}