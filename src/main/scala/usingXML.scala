import scala.xml.{Node, NodeSeq}
import scala.xml.NodeSeq.seqToNodeSeq
import scala.xml.XML.{loadFile, save}

object usingXML extends App {
 val p = <p>My text</p>
//  println(p)
 val body = <body>my own body text <p>some text</p><p>more text</p></body>
// println(body)
 val book = <book category="children">
  <title lang="en">Harry Potter</title>
  <author>J K. Rowling</author>
  <year>2005</year>
  <price>29.99</price>
 </book>
// println(book)
 val evalEl = <a> Answer to 5+5 = {5 + 5} &gt; 2</a>
// println(evalEl)
// println(evalEl.text)
 val nestedEl = <div>{body}{evalEl}</div>
// println(nestedEl)
// println(body.text)
// println((book \ "author").text)

 val bookstore = loadFile("./src/main/resources/book.xml") // build in xml loading AND parsing
// println(bookstore)
 val books = bookstore \ "book"

 def getBookFromEl(el:Node): Book = {
  new Book {
   val category = (el \ "@category").text
   val title = (el \ "title").text
   val titleLang = (el \ "title" \ "@lang").text
   val authors = (el \ "author").toList.map(_.text)
   val year = if ((el \ "year").isEmpty) 2048 else (el \ "year").text.toInt
   val price = (el \ "price").text.toDouble
  }
 }

// val book1 = getBookFromEl(books(0))
// println(book1)

 //deserialization of XML into our internal data forma
 def getBookList(bookNodes: NodeSeq): Seq[Book] = {
  for (book <- bookNodes) yield getBookFromEl(book)
 }
 val bookList = getBookList(books)
 bookList.foreach(println)

// println(books)
 println(books(0).text)
 val prices = for (book <- books) yield book \ "price"
 val prices2 = for (book <- books) yield (book \ "price").text.toDouble
 prices.foreach(el => println(el.text))
 prices2.foreach(println)
 // you want all prices and you don't care for which element they are linked
 val dirPrices = (bookstore \\ "price").map(it => it.text.toDouble)
 dirPrices.foreach(println)

// import xml._
//
// implicit def richNodeSeq(ns: NodeSeq) = new {

//  def \@(attribMatch: (String, String => Boolean)): NodeSeq =
//   ns filter { _ \\ ("@" + attribMatch._1) exists (s => attribMatch._2(s.text)) }
//
// }
// val hp = bookstore \\ "book" \@ ("category", _ = "children")

 val hp = (bookstore \\ "book" filter { _ \\ "@category" exists (_.text == "children")}).text
 println(hp)
 val webBooks = (bookstore \\ "book" filter { _ \\ "@category" exists (_.text == "web")}).text
 println(webBooks)
 save("./src/main/resources/webBooks.xml", <root>{webBooks}</root>, xmlDecl = true)

 val myBook = new Book {
  val category = "children"
  val title = "Happy Potter"
  val titleLang = "en"
  val authors = List("J.K. Rowling", "Richard Galbraith")
  val year = 1997
  val price = 19.95
 }

 println(myBook.toXML)
 save("./src/main/resources/mybook.xml", myBook.toXML, xmlDecl = true)

}
