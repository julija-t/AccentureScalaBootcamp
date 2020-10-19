import scala.collection.mutable.ListBuffer

object Array_Example extends App {
  val a = Array(1,2,3,6)
  println(a(2))


//def arrayManipulation(n: Int, queries: Array[Array[Int]]) = {
//  val myArray = ListBuffer(n)
//
//  for (query <- queries) {
//    val a = query(0)
//    val b = query(1)
//    val k = query(2)
//    myArray(a) += k
//    myArray(b) -= k
//  }
//  println(myArray.max)
//}
//  arrayManipulation(10, Array((1,5,3),(4,8,7),(6,9,1)))
}
