import scala.annotation.tailrec
//Let's create our own version of while loops

@tailrec
def fruitLoops(condition : () => Boolean)(body : () => Unit) : Unit = {
  if (condition()) { //Note: condition() is how we should call a function of type : () => Boolean
    body()
    fruitLoops(condition)(body)
  }
}


//Note: condition() is how we should call a function of type : () => Boolean. This is same as

def executeFunction(a : Int)(func : Int => Int) = {
  func(a)
}

val sq = (x : Int) => x * x

executeFunction(10)(sq)

var x = 10


//() => (x > 0) is how we can call a variable of condition : () => Boolean
fruitLoops(() => (x > 0)) { () =>
  println(x)
  x = x - 1
}

//Eventhough the above can be used as a function call, it does NOT look pretty
//we can use by-name functions to make it look prettier

@tailrec
def fruitLoop(condition : => Boolean)(body : => Unit) : Unit = {
  if (condition) {
    body
    fruitLoop(condition)(body)
  }
}

//can be called via this
var y = 0
fruitLoop(y < 5){
  println(y)
  y += 1
}

//So by-name is used when we want our function call to look pretty.
//it can be called by-name i.e. without the () in other words called
//just by passing name

//It can get very confusing, so convert it to Function0 ASAP



//Suppose we have a function like this that takes a () => Boolean

def printCondition(condition : Function0[Boolean]) = println(condition())

@tailrec
def fruitLoopsV1(condition : => Boolean)(body : => Unit) : Unit = {
  printCondition(() => condition) //when we are using it it is converted into Function0[]
  if (condition) {
    body
    fruitLoopsV1(condition)(body)
  }
}

var y1 = 0
fruitLoopsV1(y1 < 5){
  println(y1)
  y1 += 1
}


//Other notes on by-name functions

//case class cannot be call by name parameters
//case class Scheduled(val time : Int, callBack : => Unit)

//but this is possible

//1. create a class with a parameter of type function with 0 arity
class Scheduled(val time : Int, callBack : () => Unit) {
  def doit = callBack()
}


//In the object, you can use a by-name parameter and convert the by-name into a function-arity
//by writing it in {() => callback}

object Scheduled {
  def apply(time: Int, callBack: => Unit): Scheduled = new Scheduled( time, {() => callBack})
}

val scheduled = Scheduled(10, {println("hi")})

//you cannot call that parameter directly. so use a def with 0 parameters and assign the 0 arity function
//to it
scheduled.doit
