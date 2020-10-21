import scala.collection.mutable
import scala.io.Source

object ArrayManipulation2 extends App{
  val t1 = System.nanoTime
  val filePath = "./src/resources/inp1.txt"
  val lines = Source.fromFile(filePath).getLines.toArray
  lines.foreach(println)

  val instructions = lines.drop(1).map(line => line.split(" ").map(_.toInt)).flatten
  println(instructions.mkString("|"))

  val myMap = mutable.Map[Int, Int]()
  for (Array(a, b, k) <- instructions.sliding(3,3))
    for (el <- Range.inclusive(a, b))
      if (myMap.contains(el)) myMap(el) += k
      else myMap += (el -> k)

  println(myMap)
  val answer = myMap.valuesIterator.max
  println(s"Solution is $answer")

  val duration = (System.nanoTime - t1) / 1e9d
  println(s"Program run time: $duration seconds")
}
