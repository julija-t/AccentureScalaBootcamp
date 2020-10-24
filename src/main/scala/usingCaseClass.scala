object usingCaseClass extends App {
  val p = Point(5,10)
  val p2 = Point(5,10)
  val p3 = Point(50, 90)
  val p4 = p.copy(y = 200)
  println(p.x, p.y)
  println(p == p2, p == p3)
  println(p, p4)
  println(p.z, p.zz)
  println(p.distance)
}
