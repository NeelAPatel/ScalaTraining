package LecturesP1

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)

      println("Computed factorial of " + n)
      result

    }

  println(factorial(10))


  def anotherFactorial(n: Int): Int = {
    def factHelper(x: Int, accumulator: Int): Int = // use accumulators. use as many accumulators as you need
      if (x <= 1)
        accumulator
      else
        factHelper(x - 1, x * accumulator)

    factHelper(n, 1)
  }

  @tailrec
  def concatenateTailrec(aStr: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(aStr, n - 1, aStr + accumulator)

  println(concatenateTailrec("hello", 3, ""))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailrec(n / 2, true)
  }


  println(isPrime(2003))
  println(isPrime(629))


  def fibonacci(n: Int) : Int = {
    def fiboTailrec(i: Int, accLast: Int, nextToLast: Int): Int = {
      if (i >= n)
        accLast
      else
        fiboTailrec(i + 1 /* next number */ , accLast + nextToLast, accLast)
    }
    if (n <= 2) 1
    else
      fiboTailrec(2 /* starting index */ , 1, 1)


  }

  println(fibonacci(8))
}



