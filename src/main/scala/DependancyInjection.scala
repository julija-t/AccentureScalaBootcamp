import scala.concurrent.Future

object DependancyInjection extends App {
//  def parseFromString[T](s: String): T = ...

  val myArgs = Seq("123", "true", "7.5")
  val myInt = StrParser.ParseInt.parse(myArgs(0))
  val myBoolean = StrParser.ParseBoolean.parse(myArgs(1))
  val myDouble = StrParser.ParseDouble.parse(myArgs(2))

  println(myInt, myBoolean, myDouble)
}

//  def getEmployee(id: Int)(implicit ec: ExecutionContext): Future[Employee] = ???
//  }
//
//  def getRole(employee: Employee)(implicit ec: ExecutionContext): Future[Role] = ???
//
//  implicit val executionContext: ExecutionContext = ???
//
//  val bigEmployee: Future[EmployeeWithRole] = {
//    getEmployee(100).flatMap(e =>
//      getRole(e).map(r =>
//        EmployeeWithRole(e, r)
//      )
//    )
//  }
//}
//
//case class Employee(id: Int)
//case class Role(role: String)
//case class EmployeeWithRole(ec: ExecutionContext, role: String)
//case class ExecutionContext()