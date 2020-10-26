sealed trait Expr {
  val myType = "Expression"
  def printType = println(myType)
}
case class BinOp(left: Expr, op: String, right: Expr) extends Expr {
  override val myType = "BinOp"
}
case class Literal(value: Int) extends Expr {
  override val myType = "Literal"
}
case class Variable(name: String) extends Expr{
  override val myType = "Variable"
}
