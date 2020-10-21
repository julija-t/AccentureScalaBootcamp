object FunMethods extends App{
  //we have defined a method that takes two parameters
  //one is an integer and one a function which takes integer and returns integer
  def funRunner(a: Int, f: Int => Int): Int = {
    val result = f(a)
    println(s"Logging some info on $a, the f($a) returned $result") // this could go into a log file or network stream
    f(a)
  }

  def myAdder(a: Int): Int ={
    a + 100
  }
  println(funRunner(10, i => i * 5))
  println(funRunner(10, myAdder))
  println(funRunner(200, i => i*i))
  println(funRunner(200, _*50)) //shorthand of the above function declaration
}
