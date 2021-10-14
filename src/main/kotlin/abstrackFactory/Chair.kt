package abstrackFactory

class Chair : Tree, Dsp {
  override fun makeOfDsp() {
    println("Стул из ДСП")
  }

  override fun makeOfTree() {
    println("Стул из дерева")
  }
}