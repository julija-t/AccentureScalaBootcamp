//since we are not going to be storing data, just methods, it makes sense tha
//this will be an object - a single instance of the class
object PatternMatch {
  def dayOfWeek(x: Int): String = x match {
    case 1 => "Mon"
    case 2 => "Tue"
    case 3 => "Wed"
    case 4 => "Thu"
    case 5 => "Fri"
    case 6 => "Sat"
    case 7 => "Sun"
    case _ => "Unknown"
  }

  def getFizzBuzz(beg: Int = 1, end: Int = 100, fizz: Int = 3, buzz: Int = 5) = {
    val result = for (i <- Range.inclusive (beg, end)) yield {
      (i % fizz, i % buzz) match {
        case (0, 0) => "FizzBuzz"
        case (0, _) => "Fizz"
        case(_, 0) => "Buzz"
        case _ => i.toString
      }
    }
    result
  }

  def direction (p: Point) = p match {
    case Point(0, 0) => "origin"
    case Point(_, 0) => "horizontal"
    case Point(0, _) => "vertical"
    case mp if mp.x > 0 && mp.y > 0 => "Q1"
    case mp if mp.x < 0 && mp.y > 0 => "Q2"
    case mp if mp.x < 0 && mp.y < 0 => "Q3"
    case mp if mp.x > 0 && mp.y < 0 => "Q4"
    case _ => "unexpected"
      //TODO add quadrants q1 would be positive x and y) q2 would be negative x and positive y, q3 both negative
  }

  def printFizzBuzz (beg: Int = 1, end: Int = 100, fizz: Int = 3, buzz: Int = 5) =
    println(getFizzBuzz(beg, end, fizz, buzz).mkString(", "))

  def printDay(x: Int): Unit = println(dayOfWeek(x))


}
