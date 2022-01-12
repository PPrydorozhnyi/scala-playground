package lectures.par2oop

object AbstractDataTypes extends App {

  //abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "dog"

    override def eat: Unit = println("woof")
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredEat: String = "meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    override def eat(animal: Animal): Unit = println(s"$creatureType eats ${animal.creatureType}")
    override def eat: Unit = println("corcr")
  }

  //difference between abstract class and trait
  // 1- traits do not have constructors; possible in scala 3
  // 2- multiple traits can be inherited
  // 3 - traits = behavior, abstract class = "things"


}
