import scala.io.StdIn.readLine

object Anagram extends App {
  val word = readLine("Please enter word to test ")
  val checkWord = readLine("Please enter your guess ")

  def showAllAnagrams(word: String): Seq[String] = {
    word.toSeq.permutations.map(_.mkString("")).toSeq
  }

  def isAnagram(word: String, checkWord: String) = {
    word.toSeq.sorted.unwrap == checkWord.toSeq.sorted.unwrap
  }

  val anagrams = showAllAnagrams(word)
  println(isAnagram(word, checkWord))
  anagrams.foreach(println)
}
