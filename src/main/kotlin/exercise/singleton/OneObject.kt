package exercise.singleton

class OneObject private constructor() {
  companion object {
    private var instance: OneObject? = null
    fun getInstance(): OneObject? {
      if (instance == null) {
        instance = OneObject()
      }
      return instance
    }
  }
}