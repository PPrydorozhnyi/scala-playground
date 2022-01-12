package lectures.par2oop

object Objects extends App {

  // scala does not have class-level functionality("static)

  object Person {
    //static class-level
    val N_EYES = 2
    def canFly: Boolean = false
    // some kind of factory method
    def apply(father: Person, mother: Person): Person = new Person("Bobby")
  }

  class Person(val name: String) {
    //instance-level functionality

  }
  // companions

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = singleton instance
  val dummyImplicit = Person

  val marry = new Person("Marry")
  val john = new Person("John")

  val child = Person(marry, john)


  //scala applications = scala object
  // def main(args: Array[String]): Unit

}
