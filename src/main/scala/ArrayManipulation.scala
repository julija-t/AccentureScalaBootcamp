import scala.io.Source

object ArrayManipulation extends App{
  val t1 = System.nanoTime
  val filePath = "./src/resources/inp1.txt"
  val lines = Source.fromFile(filePath).getLines.toArray
  lines.foreach(println)
  val n = lines(0).split(" ")(0).toInt
  val m = lines(0).split(" ")(1).toInt
  println(n,m)
  val instructions = lines.drop(1).map(line => line.split(" ").map(_.toInt))
  instructions.foreach(el => println(el.mkString(":")))

  val a = new Array[Int](n+1)
  println(a.mkString("|"))
  instructions.foreach(job => mutateArray(a, job(0), job(1), job(2)))
  println(a.mkString("|"))
  def mutateArray(a: Array[Int], beg: Int, end: Int, delta:Int) = {
//    for (i <- beg-1 until end) {
//      a(i) += delta
//    }
    a(beg) += delta
    //so we are representing that from beg to end the change was delta
    a(end) -= delta
  }

  //TODO reconstruct the values
  //We need a cumulative sum function
  def cumSum(a: Array[Int]): Array[Int] = {
    for(i <- 1 until a.size) {
      a(i) += a(i-1)
    }
    a
  }
//  val resArr = cumSum(a).tail
  val resArr2 = a.tail.scanLeft(0)(_+_).tail
  println(resArr2.mkString(" "))
  val answer = resArr2.max
  println(s"Solution is $answer")
  val duration = (System.nanoTime - t1) / 1e9d
  println(s"Program run time: $duration seconds")
}
