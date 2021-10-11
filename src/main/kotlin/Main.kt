
//class Singleton private constructor() {
//  companion object {
//    private var instance : Singleton? = null
//    fun getInstance() = synchronized(this) {
//      if(instance == null)
//          instance = Singleton()
//        instance
//    }
//  }
//}

fun main() {
  println(OneObject.getInstance())
  println(OneObject.getInstance())
  println(OneObject.getInstance())
}


