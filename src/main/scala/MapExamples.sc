val m = collection.immutable.Map("one" -> 1, "two" -> 2, "three" -> 3)
m("one")
m("three")
val m2 = Array(("name", "Valdis"),("likes", "biking"), ("loves", "food")).toMap
m2("likes")
val mutableMap = collection.mutable.Map[String, String]() //so I create an empyt mutable map
mutableMap ++= m2
mutableMap
mutableMap("wants") = "sleep"
mutableMap
mutableMap.foreach({ case (k, v) => println(s"key $k -> value : $v") })
mutableMap.getOrElseUpdate("loves", "everything")
mutableMap.getOrElseUpdate("breakfast", "omelet")
mutableMap("name") = "Maija"
mutableMap
mutableMap("likes") = "omelet"
val mutArrMap = collection.mutable.Map[String, Array[String]]()
mutArrMap("name") = Array("Valdis", "Maija", "Liga")
mutArrMap("foods") = Array("sandwich", "omelet", "porridge")

mutArrMap.getOrElse("foods", "Default")
mutArrMap.getOrElse("drinks", "Default")
mutArrMap.getOrElse("name", "Default")

def iterateOverSomething[T](items: Iterable[T]): Unit = {
  for (i <- items) println(i)
}

iterateOverSomething(mutArrMap("name"))
iterateOverSomething(mutArrMap)

val mySet = Set(1,2,3,11,3,5,34)
iterateOverSomething(mySet)

def getIndexZeroAndTwo[T](items: IndexedSeq[T]): (T, T) = (items(0), items(2))
getIndexZeroAndTwo(Vector(1,2,3,4,5))
mutArrMap.get("badkey")
mutArrMap.contains("foods")
mutArrMap.keys
mutArrMap.keySet
mutArrMap.keysIterator.foreach(println)
//mutArrMap.keysIterator.next()
val it = mutArrMap.keysIterator
while(it.hasNext) println (it.next())
mutArrMap
