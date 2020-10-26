import PatternMatch._

import scala.util.Random

object UsingPatterMatch extends App{

  val r = new Random(42)

  PatternMatch.printDay(4)
  PatternMatch.printDay(70)

  printFizzBuzz(end = 20)

  val p = Point(0,0)
  val p2 = p.copy(x = 30)
  val p3 = p.copy(y = 40)
  val p4 = p.copy(x = 10, y = 20)
  val p5 = p.copy(x = -10, y = -20)
  println(direction(p))
  println(direction(p2))
  println(direction(p3))
  println(direction(p4))
  println(direction(p5))

  def randomRange(beg: Int, end: Int) = {
    beg + r.nextInt((end - beg) + 1)
  }
  val points = for (i <- Range.inclusive(1, 10)) yield Point(randomRange(-5,5), r.between(-5, 5+1))
  points.foreach(pt => println(pt, direction(pt)))

  points.combinations(2).toList.foreach(l => matchDistance(l(0), l(1)))

}
