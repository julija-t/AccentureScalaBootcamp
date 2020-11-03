import com.typesafe.scalalogging._
import org.slf4j.LoggerFactory


object UsingLog extends App {

  println("Let's use some logging")
  val expensive = 555
  val cheap = 222
  //val logger = Logger(LoggerFactory.getLogger(this.getClass))
  val logger = Logger("myLogger")
  logger.info(s"Service started")
  logger.error(s"Some $cheap message!")
  logger.debug(s"Some $expensive message!")

}
