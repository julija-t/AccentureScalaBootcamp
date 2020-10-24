object Iterables extends App {
  val myNumbers = new MyIterable[Int](Vector(1,2,3,4,5))
  myNumbers.foreach(println)
  val a = new MyIterable(Vector(1,2,3))
  a.map(_+1) // res0: Iterable[Int] = List(2, 3, 4)
  val c = a.filter(_%2==1) // res1: Iterable[Int] = List(1, 3)
  a.foreach(println)

  a.getInfo()

  val d = MyIterable(c, name = "My filtered Iterable")
  d.getInfo()
  println(d)
}
