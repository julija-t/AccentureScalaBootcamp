import scala.io.Source

object ArrayManipulation extends App{
  val filePath = "./src/resources/inp1.txt"
  val lines = Source.fromFile(filePath).getLines.toArray
  lines.foreach(println)
  val n = lines(0).split(" ")(0).toInt
  val m = lines(0).split(" ")(1).toInt
  println(n,m)
  val instructions = lines.drop(1).map(line => line.split(" ").map(_.toInt))
  instructions.foreach(el => println(el.mkString(":")))

  val a = new Array[Int](n)
  println(a.mkString("|"))
//  instructions.foreach(job => a.slice(job(0)-1, job(1)).foreach(el => el + job(2)))
  instructions.foreach(job => mutateArray(a, job(0), job(1), job(2)))
  println(a.mkString("|"))
  def mutateArray(a: Array[Int], beg: Int, end: Int, delta:Int) = {
    for (i <- beg-1 until end) {
      a(i) += delta
    }
    a
  }
  val answer = a.max
  println(s"Solution is ${a.max}")
}
