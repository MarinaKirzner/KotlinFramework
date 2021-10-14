package abstrackFactory

class Table : Tree, Dsp {
  override fun makeOfDsp() {
    println("Стол из ДСП")
  }

  override fun makeOfTree() {
    println("Стол из дерева")
  }

}