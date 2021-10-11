class OneObject private constructor(){
  companion object {
    private var instance : OneObject? = null
    fun getInstance() = synchronized(this) {
      if(instance == null)
        instance = OneObject()
      instance
    }
  }
}