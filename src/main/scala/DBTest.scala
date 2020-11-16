import scala.collection.mutable.ListBuffer
// https://www.sqlitetutorial.net/sqlite-sample-database/
// https://alvinalexander.com/scala/scala-jdbc-connection-mysql-sql-select-example/
// https://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/
// driver https://github.com/xerial/sqlite-jdbc

object DBTest extends App{
  println("Testing DB Connection!")
  val url = "jdbc:sqlite:C:/sqlite/db/chinook.db"

  import java.sql.DriverManager

  val conn = DriverManager.getConnection(url)

  val statement = conn.createStatement()

  val sql =
    """
      |SELECT * FROM albums
      |LIMIT 20""".stripMargin

  //val resultSet = statement.executeQuery("SELECT * FROM ARTISTS LIMIT 10")
  val resultSet = statement.executeQuery(sql)
  val meta = resultSet.getMetaData
  println(meta.getColumnCount)
  var colSeq = ListBuffer[String]()
  for (i <- 1 to
    meta.getColumnCount) {
    println(meta.getColumnName(i))
    colSeq += meta.getColumnName(i)
  }
  println(colSeq)


  while ( resultSet.next() ) {
    colSeq.foreach(col => print(col, resultSet.getString(col)))
    println()
    //val host = resultSet.getString("ArtistId")
    //val user = resultSet.getString("name")
    //println("host, user = " + host + ", " + user)
  }

  println("--------------------------------------")
  println(resultSet.getClass)

}