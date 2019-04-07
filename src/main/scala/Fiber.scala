import scalaz.zio._
import scalaz.zio.console.putStrLn

object Fiber extends App {

  override def run(args: List[String]) =
    for {
      res <- fib(4)
      _ <- putStrLn(res.toString)
      rc <- fib(5) race fib(4)
      _ <- putStrLn(rc.toString)
    } yield (0)

  def fib(n: Int): IO[Nothing, Int] =
    if (n <= 1) {
      IO.succeedLazy(1)
    } else {
      for {
        fiber1 <- fib(n - 2).fork
        fiber2 <- fib(n - 1).fork
        v2 <- fiber2.join
        v1 <- fiber1.join
      } yield v1 + v2
    }
}
