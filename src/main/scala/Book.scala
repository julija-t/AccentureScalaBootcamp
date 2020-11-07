abstract class Book {
  val category: String
  val title: String
  val titleLang: String //perhaps some sort of option, prefedined languages
  val authors: List[String] // we could have multiple authors
  val year: Int //could also use some data format
  val price: Double //possibly some money related format

  override def toString = s"${authors.head}: $category $title in $titleLang from $year"

  def getAuthorSeq() =
    for (author <- authors) yield <author>{author}</author>

  //TODO add attributes and author list
  def toXML = <book >
    <category>{category}</category>
    <title lang="en">{title}</title>
    {getAuthorSeq()}
    <year>{year}</year>
    <price>{price}</price>
  </book>
}
