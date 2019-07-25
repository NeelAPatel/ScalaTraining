package LecturesP1

object CBNvsCBV extends App{


  // type is long because big number
  def calledByValue(x: Long): Unit = {
    println("By Value: " + x)
    println("By Value: " + x)
  }

  // => means called by Name
  def calledByName(x: => Long): Unit = {
    println("By Name: " + x)
    println("By Name: " + x)
  }


  calledByValue(System.nanoTime())
  // nanoTime -> creates value -> sends to Value method -> constant value inside defintion

  // nanoTime -> copied and replaces variable name inside function -> thus called everytime.
  // => : delays evaluation inside parameter header until its called ==> called everytime
  // => : passes an expression! not value!
  calledByName(System.nanoTime())

  //Useful:
  /*
  Lazy Streams
  things that fail
   try/catch scenarios?

   */


  def infinite(): Int = {
    1 + infinite()
  }

  def printFirst (x:Int, y: => Int) = println(x)

  //printFirst(infinite(), 34)

  printFirst(34, infinite())
}
