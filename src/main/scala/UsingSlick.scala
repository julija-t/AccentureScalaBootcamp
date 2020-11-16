import org.opal.db.model.Tables

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object UsingSlick extends App{
  println("Trying Slick")
  import slick.jdbc.SQLiteProfile.api._ // must import
  val db = Database.forURL(url = "jdbc:sqlite:c:/sqlite/db/chinook.db", driver="org.sqlite.JDBC")
  val tables = Tables
  val albums = tables.Albums
  val genres = tables.Genres
  //  println(genres.toString())
  //  db.run(genres.result).map(res => res.foreach {
  //    case (Genres.) =>
  //      println("something")
  //  })
  //  })
  val q = genres.map(_.name) // so this creates an SQL query out of scala code an example of ORM
  val action = q.result
  val result: Future[Seq[Option[String]]] = db.run(action)
  val sql = action.statements.head
  println(sql)
  Thread.sleep(1500) //shouldnt be needed
  println("Awoke now")
  var myVector: Seq[Option[String]] = Seq(Option("Aha"))
  result.onComplete {
    case Success(s) => {
      println(s"Result: $s")

    }
    case Failure(t) => t.printStackTrace()
    case _ => println("Unknown happened")
  }
  myVector.foreach(println)

  //  result.foreach(println)

}
