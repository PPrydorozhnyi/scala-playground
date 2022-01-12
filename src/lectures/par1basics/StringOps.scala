package lectures.par1basics

object StringOps extends App {

  val str = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase)
  println(str.length)


  val aNumberString = "45"

  val aNumber = aNumberString.toInt

  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2)) // He

  // Scala specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, me name $name and I will be turning ${age + 1}"

  println(greeting)

  //F-interpolators

  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.3f burgers per minute"

  println(myth)

  // raw-interpolator

  println(raw"This is a \n newline") // no caret return will be printed
  val escaped = "This is a \n newline"
  println(raw"$escaped") // This is a
  //newline

}
