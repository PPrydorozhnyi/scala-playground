package lectures.par2oop

object Inheritance extends App {

  // single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    val color: String = "black"
    protected def eat: Unit = println("nommy")
  }

  class Cat extends Animal {
    def crunch: Unit = eat
  }

  val cat = new Cat

  cat.crunch

  //constructors
  class Person(name: String, age: Int)

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //overriding
  class Dog(override val color: String) extends Animal {
    override val creatureType: String = "pet"
    override def eat: Unit = {
      super.eat
      println("crunch")
    }
  }

  val dog = new Dog("white")

  dog.eat
  println(dog.creatureType)
  println(dog.color)

  //preventing override
  // final on member
  // final on class
  // seal class = extend classes only in this file

}
