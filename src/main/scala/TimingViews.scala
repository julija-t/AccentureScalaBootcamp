object TimingViews extends App {
  val t1 = System.nanoTime

  for (i <- 1 to 100000){
    i * 1000
  }

  val duration = (System.nanoTime - t1) / 1e9d
  println(s"Program run time: $duration seconds")
}
