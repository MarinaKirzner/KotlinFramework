package core.db

object SqlQuery {

  val selectClientByIdQuery: String = """
    SELECT * FROM mrt.client WHERE id = :id
  """.trimIndent()

  val selectClientByContainsPartOfEmail: String = """
   SELECT * FROM mrt.client WHERE email LIKE :partEmail AND email Like :emailContainsNumber
  """.trimIndent()

  val selectClientDbDataQuery: String = """
  SELECT 
  CONVERT(mrt.client.client_type USING utf8) as clientType,
  mrt.client.nickname, mrt.client.resident,
  CONVERT(mrt.client.identification_number USING utf8) as identificationNumber
  FROM mrt.client
  WHERE id = :id
""".trimIndent()

  val selectClientIndividualDbDataQuery: String = """
  SELECT 
  mrt.client_individual.surname, mrt.client_individual.name,
  CONVERT(mrt.client_individual.middle_name USING utf8) as middleName,
  CONVERT(mrt.client_individual.full_name_changed USING utf8) as fullNameChanged,
  CONVERT(mrt.client_individual.previous_surname USING utf8) as previousSurname,
  CONVERT(mrt.client_individual.previous_name USING utf8) as previousName,
  CONVERT(mrt.client_individual.previous_middle_name USING utf8) as previousMiddleName,
  CONVERT(mrt.client_individual.insurance_number USING utf8) as insuranceNumber
  FROM mrt.client_individual
  WHERE id = :id
""".trimIndent()
}