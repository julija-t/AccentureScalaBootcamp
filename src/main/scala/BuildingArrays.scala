object BuildingArrays extends App{
  val a = for (i <- 1 to 5) yield {i * 10}
  a.foreach(println)

  val b = Array.newBuilder[Int]
  for (i <- 1 to 5) {
    b += i * 100
  }
  val built = b.result()
  built.foreach(println)
}
