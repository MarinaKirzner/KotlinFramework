package core.db

val selectClientByIdQuery: String = """
    SELECT * FROM mrt.client WHERE id = :id
  """.trimIndent()

val selectClientByContainsPartOfEmail: String = """
   SELECT * FROM mrt.client WHERE email LIKE :partEmail AND email Like :emailContainsNumber
  """.trimIndent()