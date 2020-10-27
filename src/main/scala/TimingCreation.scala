object TimingCreation extends App{
  val mt = new MyTimer()
  mt.measureTime(Array(1,2,3,4))
  mt.measureTime(5+5)
  mt.measureTime(2.0+3.5)
  mt.measureTime(Vector(1,2,3,4))
  def myLoop(endVal: Int = 1000) = {
    for (i <- 1 to endVal) {
      i * 500
    }
  }
  mt.measureTime(myLoop(50000))
  mt.measureTime(myLoop(1000000))
  mt.measureTime(myLoop(1000000000))

  val nrOfLoops = 1000
  val collectionSize = 1000

  var timeArray: Long = 0
  var timeList: Long = 0
  var timeSeq: Long = 0
  var timeVector: Long = 0

  for(i <- 1 to nrOfLoops) {
    timeArray += mt.measureTime(Range(1, collectionSize).toArray)
    timeList += mt.measureTime(Range(1, collectionSize).toList)
    timeSeq += mt.measureTime(Range(1, collectionSize).toSeq)
    timeVector += mt.measureTime(Range(1, collectionSize).toVector)
  }

  val myCollections = Array(timeArray, timeList, timeSeq, timeVector)

  myCollections.foreach(col => println(s"Average time: ${col / nrOfLoops} nanoseconds"))

}
