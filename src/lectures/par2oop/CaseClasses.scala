package lectures.par2oop

object CaseClasses extends App {

  // equals, hashCode, toString

  case class Person(name: String, age: Int)

  //class parameters are fields
  var jim = new Person("Jim", 49)
  println(jim.name)

  // sensible toString
  println(jim)

  //equals and hashCode
  var jim2 = new Person("Jim", 49)
  println(jim == jim2) //true

  // copy method
  val jim3 = jim.copy(age = 13)
  println(jim3)

  // have companion objects

  val thePerson = Person
  val mary = Person("Mary", 23)

  // CC are serializable
  // Akka usages

  //cc have extractor patterns - can be used in Pattern matching


  case object UnitedKingdom {
    def name: String = "The UK"
  }

  UnitedKingdom

}
