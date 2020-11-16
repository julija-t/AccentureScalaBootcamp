import org.sqlite.JDBC
import slick.jdbc

import scala.concurrent.ExecutionContext.Implicits.global
//import slick.driver.SQLiteDriver.api._
import slick.jdbc.SQLiteProfile.api._
import slick.codegen.SourceCodeGenerator


object GenSlickModel extends App {
  println("Testing Slick connection")

  val db = Database.forURL("C:\\sqlite\\db\\chinook.db", driver = "org.sqlite.JDBC")

  //so this code generator should run whenever we change our Database schema
  slick.codegen.SourceCodeGenerator.main(
    Array(
      "slick.jdbc.SQLiteProfile",
      "org.sqlite.JDBC",
      "jdbc:sqlite:C:/sqlite/db/chinook.db",
      "src/main/scala",
      "org.opal.db.model",
      "chinook",
      "test",
    )
  )

}
