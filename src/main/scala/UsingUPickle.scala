import java.io.{File, PrintWriter}

import ujson.{Bool, Num, Str}
import upickle.default._

import scala.io.Source

object UsingUPickle extends App{
//  println("Let's work with some JSON!")
//  println(write(Seq(1, 2, 3)))

  def getNumbers(beg: Int, end: Int) = {
    val mySeq = for (i <- beg to end) yield Seq(i, i*i, i*i*i)
    mySeq
  }

//  println(write(getNumbers(1, 10)))

  //TODO print JSON of a list of Maps with each map containing
  // key number->value, square->value squared and cube-> number cubed

  import upickle.default.{ReadWriter => RW, macroRW}

  case class Thing(number: Int, square: Int, cube: Int)
  object Thing{
    implicit val rw: RW[Thing] = macroRW
  }

  val myNumbers = getNumbers(1,10)
//  for (line <- myNumbers) println(write(Thing(line(0), line(1), line(2))))

  val myThings = for (line <- myNumbers) yield Thing(line(0), line(1), line(2))
//  println(myThings)

//  import java.nio.file.Files
//  val f = Files.createTempFile("myfile", ".json")
//  Files.write(f, write(myThings).getBytes)

  val pw = new PrintWriter(new File ("mydata.json"))
  pw.write(write(myThings, indent = 4))
  pw.close()

  val fileContents = Source.fromFile("./src/main/resources/todo.json").getLines.mkString //so this leaves file open
//  println(fileContents)
  //  val myData = read[Seq[Map[String,String]]](fileContents) //FIXME how to read arbitrary objects
  //  println(myData.getClass)

//  val myJSON = Source.fromFile("./src/main/resources/mydata.json").getLines.mkString
//  val myData = read[Seq[Map[String,Int]]](myJSON)
//  myData.foreach(println)

  val todoJSON = Source.fromFile("./src/main/resources/todo.json").getLines.mkString
  val rawData = read[ujson.Value](todoJSON)
  val todoSeq = rawData.arr
  todoSeq.foreach(println)
  val myMaps = todoSeq.map(_.obj)
  println(myMaps(1)("title"))

  val rawSeq = read[Seq[ujson.Value]](todoJSON)
  rawSeq.foreach(println)
  val todoData = read[Seq[Map[String, ujson.Value]]](todoJSON)
  todoData.foreach(obj => for((k,v) <- obj) println(s"k:$k -> v:$v"))

  def checkObj(obj: ujson.Value) = {
    obj match {
      case Num(value) => println(s"Got number! $value")
      case Str(value) => println(s"Got string! $value")
      case Bool(value) => println(s"Got boolean! $value")
      case _ => println("Need to work on covering more cases")
    }
  }

  val firstMap = todoData(1)
  for ((k,v) <- firstMap) checkObj(v)


}
