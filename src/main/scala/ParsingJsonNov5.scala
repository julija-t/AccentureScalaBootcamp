import ujson.{Bool, Num, Str}
import upickle.default._

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source

object ParsingJsonNov5 extends App{
  //TODO parse MOCK_DATA.json
  //Get gender balance Male/Female
  //Get most popular first names

//  val myJson = Source.fromFile("./src/main/resources/MOCK_DATA.json").getLines.mkString
//  val myData = read[Seq[Map[String, ujson.Value]]](myJson)
//  myData.foreach(println)
  
  val fileName = "MOCK_DATA.json"
  val jsonString = os.read(os.pwd / "src" / "main" / "resources" / fileName)
  println(jsonString.size)
  val seqMap = read[Seq[Map[String, ujson.Value]]](jsonString)
  
 case class APerson(id: Int, first_name: String,last_name: String, email: String, gender: String, ip_address: String)

 def getPersonSeq(seqMap: Seq[Map[String, ujson.Value]]) : Seq[APerson] = {
   //FIXME
   seqMap.map(t => APerson(t("id").num.toInt, t("first_name").str, t("last_name").toString,
     t("email").str, t("gender").str, t("ip_address").str))
//    Seq(APerson(9000, "Valdis", "Saulespurens", "valdis.saulespurens@gmail.com", "Male", "127.0.0.1"))
  }

  val personSeq = getPersonSeq(seqMap).toArray

  val males = personSeq.count(_.gender == "Male")
  val females = personSeq.count(_.gender == "Female")
  println(s"Out of ${personSeq.size} persons there are $males males and $females females")

  val popularName = personSeq.groupBy(_.first_name).view.mapValues(_.size).toSeq.sortBy(_._2).reverse
  popularName.slice(0,10).foreach(println)



  //TODO filter values out
}
