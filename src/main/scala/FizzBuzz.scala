object FizzBuzz extends App {
  val mySeq =
  for (i <- Range.inclusive(1,100)) yield
    if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
    else if (i % 3 == 0) "Fizz"
    else if (i % 5 == 0) "Buzz"
    else i.toString
  println(mySeq.mkString(", "))

}
