object UsingExpr extends App{

  def stringify(expr: Expr): String = expr match {
    case BinOp(left, op, right) => s"(${stringify(left)} $op ${stringify(right)})"
    case Literal(value) => value.toString
    case Variable(name) => name
  }

  def evaluate(expr: Expr, values: Map[String, Int]): Int = expr match {
    case BinOp(left, "+", right) => evaluate(left, values) + evaluate(right, values)
    case BinOp(left, "-", right) => evaluate(left, values) - evaluate(right, values)
    case BinOp(left, "*", right) => evaluate(left, values) * evaluate(right, values)
    case Literal(value) => value
    case Variable(name) => values(name)
  }

  val smallExpr = BinOp(
    Variable("x"),
    "+",
    Literal(1)
  )

  val largeExpr = BinOp(
    BinOp(Variable("x"), "+", Literal(1)),
    "*",
    BinOp(Variable("y"), "-", Literal(1))
  )

  println(smallExpr)
  smallExpr.printType
  println(stringify(largeExpr))
  largeExpr.printType
  println(evaluate(smallExpr, Map("x" -> 50)))
  println(evaluate(largeExpr, Map("x" -> 50, "y" -> 10)))

}
