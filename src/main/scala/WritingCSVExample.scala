import java.io.File
import com.github.tototoshi.csv.{CSVWriter, DefaultCSVFormat}

object WritingCSVExample extends App {

  val myFile = "./src/main/resources/power-table.csv"

  def getNumbers(beg: Int, end: Int) = {
    val mySeq = for (i <- beg to end) yield Seq(i, i*i, i*i*i)
    mySeq
  }

  implicit object MyFormat extends DefaultCSVFormat {
    override val delimiter = ';'
  }

  def saveNumbers(saveFile: String) = {

    val myFile = new File(saveFile)
    val writer = CSVWriter.open(myFile)
    writer.writeRow(Seq("number", "square", "cube"))
    writer.writeAll(getNumbers(1, 10))

    writer.close()

  }

  saveNumbers(myFile)

}
