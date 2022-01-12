package lectures.par2oop

object Generics extends App {

  class MyList[+A] {
    //use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal
     */
  }

  val listOfIntegers = new MyList[Int]

  //generic methods
  object MyList{
    def empty[A]: MyList[A] = ???
  }

  val empty = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // List[Cat] extends List[Animal] = covariance
  class CovariantList[+A]

  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? hard to say => we return a list of Animals

  // no = invariant
  class InvariantList[A]
  val inAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // definitely no - contravariance
  class Trainer[-A]
  val covariantList: Trainer[Cat] = new Trainer[Animal]

  //bounded types
  class Cage[A <: Animal](animal: Animal)
  val cage = new Cage(new Dog)

  class Car
//  val newCage = new Cage(new Car)
}
