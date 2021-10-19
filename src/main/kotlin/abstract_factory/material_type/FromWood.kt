package abstract_factory.material_type

class FromWood: CreateMaterial {
    companion object {
      const val wood: String = "from Wood"
    }

    override fun createMaterial(): String {
      println(wood)
      return wood
    }
}