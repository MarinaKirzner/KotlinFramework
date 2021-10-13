package singleton

class OneObject private constructor(){
  companion object {
    private var instance : OneObject? = null
    fun getInstance() {
      if(instance == null)
        instance = OneObject()
      instance
    }
  }
}