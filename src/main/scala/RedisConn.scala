import com.redis.RedisClient

object RedisConn extends App{
  println("Connecting to Redis")

  val host = scala.util.Properties.envOrElse("REDISHOST", "undefinied")
  val port = 17953
  val secret = scala.util.Properties.envOrElse("REDISPW", "undefinied")

  val r = new RedisClient(host, port, 0, Some(secret))
  r.set("name", "Julija")
  println(r.get("name"))
  r.lpush("list-1", "foo")
  r.rpush("list-1", "bar")
  println(r.llen("list-1"))


}
