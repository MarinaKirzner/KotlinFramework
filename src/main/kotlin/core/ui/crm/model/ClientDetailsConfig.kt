package core.ui.crm.model

import core.ui.crm.ClientType

data class ClientDetailsConfig(
  val clientType: ClientType? = ClientType.INDIVIDUAL,
  val nickname: String? = null,
  val resident: Boolean? = null,
  val identificationNumber: String? = null,
  val surname: String? = null,
  val name: String? = null,
  val middleName: String? = null,
  val fullNameChanged: Boolean? = null,
  val previousSurname: String? = null,
  val previousName: String? = null,
  val previousMiddleName: String? = null,
  val insuranceNumber: String? = null
)