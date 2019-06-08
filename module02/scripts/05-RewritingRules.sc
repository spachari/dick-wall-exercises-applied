val x = 1 + 2

val y = 1.+(2)

//we are using 1 on + and add it by 2

val s = "hello"

s.charAt(1)
s charAt 1

// println "hello" // will not compile

System.out println "hello"

// --- apply and update

val arr = Array("scooby", "dooby", "doo")

arr.apply(1)

arr(0)


arr.update(0, "scrappy")

arr(1) = "dappy"

println(arr.deep)

val arr2 = Array.apply(1,2,3)

val z = 10
// z(2) // does not compile

val xs = List(1,2,3)
xs(1)  // works
// xs(1) = 10 // does not compile


//Rule 1
//You can write a statement that takes an instance and uses it on a method
//add.addSomething(2)
//like this
//add addSomething 2

class Additions {
  def addSomething(x : Int) = x * 2
}

val add = new Additions
add addSomething 2

//This will then be rewritten to
add.addSomething(2)

val args = Array("John", "Jane")

//Rule 2
//When you call a singleton immedietely followed by a
//paranthesis, all it is doing is calling it's apply method

args(0) //all it is doing is calling args.apply(0)

//Rule 3
//when you call it and pass an equal to, all it is doing is
//calling the update method
args(1) = "Zoe" //all it is doing is calling args.update(0, "Zoe")

//Re-writing will be only done if the code
//Scala will never re-write anything if it will compile without re-writing it
//If it cannot compile, then it will try and re-write

//For example

val list = List(1,2,3)

//list(0) = 10

//list(0) = 10 will attempt to re-write the .update method and tell you that
// it is not present. In short, if it can compile (typecheck) it will not re-write


//Rule 4
//java style re-writing

import scala.collection._

val s1 = mutable.Set(1,2,3)
s1 -= 2

var s2 = immutable.Set(1,2,3)
s2 -= 2 //but this method -= is not available in immutable.Set() it just did s2 = s2 - 2
println(s2)

//Rule 5
//when we write
val m1 = "hello" -> 88

//What happens is scala first re-writes it to
//val m1 = "hello".->(88)

//Then realises that there is no -> method for string
// and then looks for implicits and wraps "hello".->(88) to ArrowAssoc("hello").->(88)

//There is an implicit wrapper present in Predef
//It makes val m1 = "hello" -> 88 to val m1 = ArrowAssoc("hello").->(88)
//ArrowAssoc[Any]() has the method -> in it.


//the ArrowAssoc implicit class in predef provides automatic conversion of Any
// type in Scala to a type that has a -> method on it (which takes the second argument
// and returns a tuple of the pair)