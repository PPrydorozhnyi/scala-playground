package lectures.par2oop

import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person) = s"$name is hanging with ${person.name}"
    def +(person: Person) = hangOutWith(person)
    def +(postfix: String): Person = new Person(s"$name ($postfix)", favoriteMovie)
    def unary_! : String = s"not $name"
    def isAlive: Boolean = true
    def apply(): String = "Hi world"
    def apply(number: Int) = s"$name watched $favoriteMovie $number times"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def learns(ler: String) = s"$name learns $ler"
    def learnsScala = learns("Scala")
  }

  val mary = new Person("Mary", "Inception")

  println(mary likes "Inception") // infix notation = operator notation

  // "operators" in Scala

  val tom = new Person("Tom", "Fight CLub")
  println(mary hangOutWith tom)
  println(mary + tom)

  println(1.+(2))

  // all operators are methods


  //prefix notation
  val x = -1
  val y = 1.unary_-
  // unary_ prefix works with + - ~ !

  println(!mary)

  //postfix notations
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary())

  //exercises

  println((+mary).age)
  println(mary learns "Java")
  println(mary(2))
}
