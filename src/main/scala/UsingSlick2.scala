import org.opal.db.model.Tables
import slick.jdbc.SQLiteProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object UsingSlick2 extends App {

  val db = Database.forConfig("SQLiteChinook")
  try {

    val tables = Tables
    val albums = tables.Albums
    val genres = tables.Genres

    val filteredAlb = albums.filter(album => album.title like "%rock%") // so this creates an SQL query out of scala code an example of ORM
    val action = filteredAlb.result.map(println)
//    val setupFuture: Future[Seq[Option[String]]] = db.run(action)
    val setupFuture: Future[Unit] = db.run(action)



    Await.result(setupFuture, Duration.Inf)

  } finally db.close
}
