import scala.collection.mutable
import scala.collection.mutable.Map
val myMap2 = mutable.Map[Int, Int]()

val instructions = Array(1,2,100,2,5,100,3,4,100)
for (Array(job1, job2, job3) <- instructions.sliding(3,3)) for (el <- Range.inclusive(job1, job2)) if (myMap2.contains(el)) myMap2(el) += job3 else myMap2 += (el -> job3)
myMap2
myMap2.valuesIterator.max