package lectures.par2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age + " " + person.x)
  println(person.greet("Daniel"))

  val counter = new Counter
  val counter1 = new Counter
  println(counter.equals(counter1))
}

class Person(
              name: String, // class param
              val age: Int = 0 // field
            ) {
  //body
  val x = 2 // field

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says hi to $name")

  def greet(): Unit = println(s"$name says hi")
  def greet(n: Int): Int = 42

  // multiple constructors
  def this(name: String) = this(name, 0) // should call other constructor
}

// class parameters parameters NOT FIELDS


class Writer(name: String, surname: String, val year: Int) {
  def fullName(): String = s"$name $surname"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge() : Int = author.year
  def isWrittenBy(authorCheck: Writer) = author.equals(authorCheck)
  def copy(novel: Novel) = new Novel(name, yearOfRelease + 1, author)
}

class Counter(val value: Int = 0) {
  def increment: Counter = increment(1)
  def increment(incrementBy: Int) : Counter = new Counter(value + incrementBy)
  def decrement(decrementBy: Int): Counter = new Counter(value - decrementBy)
  def decrement: Counter = decrement(1)
}
