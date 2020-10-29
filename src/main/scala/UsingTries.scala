object UsingTries extends App{
  val myTrie = new MyTrie()

  myTrie.add("Valdis")
  myTrie.add("Val")
  myTrie.add("Vald")
  myTrie.add("V")

  myTrie.add("Voldemars")
  myTrie.add("Valdemārs")
  myTrie.add("Līga")
  myTrie.add("Līgavas")

  println(myTrie.contains("Valdis"))
  println(myTrie.contains("October"))

  val result = myTrie.prefixesMatchingString0("Valdis")
  println(result.mkString(","))

  myTrie.printAll()
}
