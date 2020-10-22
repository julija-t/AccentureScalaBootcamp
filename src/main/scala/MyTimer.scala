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
}