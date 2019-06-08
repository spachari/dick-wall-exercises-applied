//Until this point we have seen only functions that take a value and produces an output
val sq = (x : Int) => x * x

//and we have called it like htis

sq(10)

sq(20)

sq(100)

val output = math.sqrt(4.0)

val output1 = math.sqrt(-4.0)
//see here, there is no number that can be multiplied by itself
//and get a negative number

//Partial functions are created to solve this purpose
//It extends Function1[], therefore can be used in place of Function1[]
//because it is its subtype, but it can be defined a function
// that is not necessarily defined for all of it's input.

//Example1

val pft1 : PartialFunction[Int, Int] = {
  case x : Int if x > 0 => x + x
  case x => x * -1
}

//Points to remember:
//1. A partial function extends only Function1[T,R] so it can only have
//type PartialFunction[Int, Int].
//2. it starts with a { and then immedietely followed by a case statement
// with a match in front of it (pattern match). for example catch {} block
//uses a partial function


//this will not work
/*
val pft2 : PartialFunction[Int, Int, Int] = {
  case x : Int if x > 0 => x + x
  case x => x * -1
}
*/

//a partial function is a complete function except it is defined for
//all of it's inputs.

//the word partial comes in because we can apply different functions depending on
//it's pattern match

//what we can do with it is this
val fn1 : Int => Int = pft1

//we can convert a partial function to a function of type Function1[] because it is
//an upcast to the parent type

val nums = (-5 to 5).toList

nums.map(fn1)

//why is this important

//let's say we use create thsi function

val pft2 : PartialFunction[Int, Int] = {
  case x if ( x > 0) => x * 2
}

//if we apply the nums.map() on pft2, we get a match error
//nums.map(pft2)

//but if we apply a collect()

nums.collect(pft2)

//it filters out the non matching values

//How does it work?

//it works by creating two methods
//1. apply

//2. isDefinedAt

def isDefinedAt(x : Int) = x match {
  case x : Int if (x > 0) => true //note that all the bits till the rocket
                                  //case x if ( x > 0) => are the same in true
  case _ => false                 //creates a catch all default match and assigns it to false
}

isDefinedAt(5)
isDefinedAt(-5)

//collect will use isDefinedAt to check if it is false or true and then applies
// the function only on true values

//Usages of partial functions
//1. pattern matching

val x = 10

x match {
  case x : Int if (x > 10) => x * 2
  case _ => x.abs
}

//try catch block

val output3 = try {
  x / 10
} catch {
  case x : ArithmeticException => 0
}

//so anywhere we see a { followed by a case, we are using PartialFunction