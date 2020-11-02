object StringFun extends App {
  def sumNumbers(text: String): Int = {

//    val numPattern = "[0-9]+".r
//    numPattern.findAllIn(text).toSeq.map(_.toInt).foldLeft(0)(_ + _)

//    ("[0-9]+".r findAllIn text).map(_.toInt).sum
    ("\\d+".r findAllIn text).map(_.toInt).sum
  }

  println(sumNumbers("Valdis has 3 cows and 58 sheep and 11horses")) //should print 72
  //so pure split will not work real data is messy!}
}
