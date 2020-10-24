case class Point(x: Int, y: Int) extends Distance {
  def z = x + y
  def zz =  {
    x + y
  }
  def distance = Math.sqrt(x*x + y*y)
}
