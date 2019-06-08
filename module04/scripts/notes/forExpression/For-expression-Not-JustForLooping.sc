import scala.concurrent._
import duration._
import ExecutionContext.Implicits.global
import scala.util.Try

//One of the rules for using for comprehension is that all generators must be
//of the same type.

//A future is something that a result is caclulated
//concurrently somewhere/somehow, that may or may not have been resolved yet.



val f1 = Future(1.0)
val f2 = Future(2.0)
val f3 = Future(3.0)

//So we can use futures as if it were present. if it is not there, Future itself will
//tell what to do in case if it is failed.

val f4 = for {
  v1 <- f1
  v2 <- f2
  v3 <- f3
} yield v1 + v2 + v3

val f5 = Await.result(f4, 10 seconds)

println(f5)

//THe above example is crucial because
//when we start working with Futures and someone has provided us with this
//asynchronous call instead of a synchronous call that we had before, but otherwise it
// is the same thing we can move out code in the yield block and we can
//de-reference our calls in the for block and it will just work

//for on Options

val o1 = Some("hello")
val o2 = Some("Srinivas")

val o3 = for {
  a <- o1
  b <- o2
} yield a + " " + b

println(o3)
//Note the result is also an option


//for on Try
val t1 = Try(100 / 0)
val t2 = Try(10 * 10)

val t3 = for {
  a <- t1
  b <- t2
} yield a * b

println(t3)

//Basically used to chain operations of the same type and yield result of the same type too
//All the types will know what to do in case there is no result (or unexpected result)
//and code will not fail in any case

//We can create our own types and use for comprehension on them.

//All we need is a type with foreach, map, flatMap, withFilter with the
//correct signatures
