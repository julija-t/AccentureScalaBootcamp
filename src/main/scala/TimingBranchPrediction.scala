object TimingBranchPrediction extends App{

  import java.util

  val timer = new MyTimer
  var r = new scala.util.Random(0)

    // Generate data
  val arraySize = 32768
  var data = new Array[Int](arraySize)

  for (c <- 0 until arraySize)
    data(c) = r.nextInt() % 256

  // !!! With this, the next loop runs faster
  data = data.sorted
//  util.Arrays.sort(data)

  // Test

  timer.start()
  var sum = 0
  for (i <- 0 until 100000) {
    // Primary loop
    for (c <- 0 until arraySize) {
      {
        if (data(c) >= 128)
          sum += data(c)
//        sum += data.filter(_ >= 128).sum
      }
    }
  }


  timer.stop()
  timer.prettyPrint()
  println(s"sum = $sum")

}
