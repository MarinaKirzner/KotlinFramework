package core.db

val mrtClientDbSelectOneRow: String = """
    SELECT * FROM mrt.client WHERE id = :id
  """.trimIndent()

val mrtClientDbSelectAllRows: String = """
    SELECT * FROM mrt.client
  """.trimIndent()