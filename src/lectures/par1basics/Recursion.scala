package lectures.par1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  def tailFactorial(n: Int) : BigInt = {
    @tailrec
    def innerFactorial(currentN: Int, result: BigInt) : BigInt = {
      if (currentN <= 1) result
      else innerFactorial(currentN - 1, currentN * result)
    }
    innerFactorial(n, 1)
  }

//  println(tailFactorial(100))

  def isPrime(n: Int) : Boolean = {
    @tailrec
    def primeHelper(currentDivision: Int) : Boolean = {
      if (n % currentDivision == 0) false
      else if (currentDivision == 2) true
      else primeHelper(currentDivision - 1)
    }

    if (n % 2 == 0) true
    else primeHelper(n / 2)
  }

  println(isPrime(669))

  def fibonacci(n: Int) : Int = {
    @tailrec
    def tailFibonacci(prev: Int, current: Int, left: Int): Int = {
      if (left == 0) current
      else tailFibonacci(current, prev + current, left - 1)
    }
    if (n == 1) 0
    else tailFibonacci(0, 1, n - 2)
  }

  println(fibonacci(13))

}
