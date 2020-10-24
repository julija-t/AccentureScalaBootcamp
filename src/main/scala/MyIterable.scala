case class MyIterable [T](xs: Iterable[T], name: String = "My Iterable") extends Iterable[T]{
  override def iterator = xs.iterator

    def getInfo(): Unit = {
      println(s" I am $name and I hold ${xs.size} items")
    }

}
