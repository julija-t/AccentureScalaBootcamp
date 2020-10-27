class MyTimer() {
  var startTime: Long = 0
  var durationTime = 0.0

  def start(): Long = {
    startTime = System.nanoTime
    startTime
  }

  def stop() = {
    durationTime = (System.nanoTime - startTime) / 1e9d
    durationTime
  }

  def prettyPrint(): Unit = println(s"Program run time: $durationTime seconds")

  def measureTime(f: => Unit) = {
    val start = System.nanoTime
    f
    val end = System.nanoTime
    val delta = end - start
//    println(s"Evaluation took $delta nanoseconds which is ${delta/1e9d} seconds")
    delta
  }

}