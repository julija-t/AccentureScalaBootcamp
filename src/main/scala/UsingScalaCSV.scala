import java.io.File
import com.github.tototoshi.csv.CSVReader


object UsingScalaCSV extends App{
  println("Going to read some files")
//  val filePath = "./src/main/resources/sample.csv"
  val filePath = "./src/main/resources/withHeaders.csv"
  val reader = CSVReader.open(new File(filePath))
//  val res = reader.all()
//  res.foreach(line => println(line.mkString(",")))

  val resMap = reader.allWithHeaders()
  resMap.foreach(myMap => for ((k,v) <- myMap) println(s"key: $k, value: $v"))
}
