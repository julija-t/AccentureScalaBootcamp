object TimingSets extends App{
  var r = new scala.util.Random(100)
  val timer = new MyTimer
  timer.start()
  for (i <- 1 to 1000000){
    val s1 = Range.inclusive(1,r.nextInt(20)).toSet
    val s2 = Range.inclusive(3,r.nextInt(15)).toSet
    s1 diff s2
  }
  timer.stop()
  timer.prettyPrint()

}
