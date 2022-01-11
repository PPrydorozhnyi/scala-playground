package lectures.par1

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def tailFact(n: Int, acc: Int = 1) : Int = {
    if (n == 1) acc
    else tailFact(n - 1, acc * n)
  }

  val fact10 = tailFact(10)

  def savePicture(format: String = "jpeg", width: Int = 800, height: Int = 800): Unit = println(s"something $format " +
    s"with $width and $height")

  savePicture()
  savePicture(width = 1900, format = "png")
  savePicture(height = 1000)

}
