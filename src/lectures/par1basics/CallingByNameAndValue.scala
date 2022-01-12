package lectures.par1basics

object CallingByNameAndValue extends App {

  def callByValue(x: Long): Unit = {
    println("by value: " + x);
    println("by value: " + x);
  }

  // looks like pass function in Java
  def callByName(x: => Long): Unit = {
    println("by name: " + x);
    println("by name: " + x);
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

}
