import kantan.xpath.implicits._ // Implicit operators and literals.

<body>My text2</body>
//val url = "https://www.w3schools.com/xml/note.xml"
val url = "https://www.w3schools.com/xml/cd_catalog.xml"
import java.net.URI
val uri = new URI(url)

val thIds = uri.evalXPath[List[String]](xp"CATALOG/CD/TITLE")
thIds.toSeq.head.foreach(println)