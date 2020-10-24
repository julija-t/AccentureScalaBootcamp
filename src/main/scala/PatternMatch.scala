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

  def printDay(x: Int): Unit = println(dayOfWeek(x))

  val hello = "hello"
}
