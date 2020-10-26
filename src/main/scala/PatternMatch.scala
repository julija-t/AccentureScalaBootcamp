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
  }

  def greet(p: Person): Unit = p match {
    case Person(s"$firstName $lastName", title) => println(s"Hello $title $lastName")
    case Person(name, title) => println(s"Hello $title $name")
    case _ => println("Hmm who are you really?")
  }

  def greet2(husband: Person, wife: Person): Unit = (husband, wife) match {
    case (Person(s"$first1 $last1", _), Person(s"$first2 $last2", _)) if last1 == last2 =>
      println(s"Hello Mr and Ms $last1")
    case (Person(s"$first1 $last1", title1), Person(s"$first2 $last2", title2)) if first1 == first2 =>
      println(s"Wow you have the same first name $first1! $title1 $last1 and $title2 $last2")
    case (Person(name1, _), Person(name2, _)) => println(s"Hello $name1 and $name2")
  }

  def matchDistance(a: Point, b: Point) = {
    (a, b) match {
      case (a, b) if a.distance == b.distance =>
        println(s"Points $a and $b are the same distance ${a.distance} from 0.0")
      case _ => println(s"Points $a and $b are different distance away")
    }
  }

  def printFizzBuzz (beg: Int = 1, end: Int = 100, fizz: Int = 3, buzz: Int = 5) =
    println(getFizzBuzz(beg, end, fizz, buzz).mkString(", "))

  def printDay(x: Int): Unit = println(dayOfWeek(x))


}
