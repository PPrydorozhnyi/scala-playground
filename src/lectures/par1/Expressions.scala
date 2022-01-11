package lectures.par1

object Expressions extends App {

  val x = 1 + 2;

  //Instruction(DO, executed) vs Expression(Value, evaluated)

  val b = true
  val aCondition = if (b) 5 else 3
  println(aCondition)

  var aVariable = 4;

  val aWeirdValue = (aVariable = 3) // Unit == void - side effect returns unit

  //side effects: println(), whiles, reassigning

  //code blocks

  val codeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  val some = {2 < 3}
  println(some)

  val other = {
    if (some) 239 else 986
    42
  }

  println(other)

}
