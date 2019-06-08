import scala.util.Random
//FUnctions have arity like tuples do.
//
// In the case of tuple how many things are in the tuple

val tuple1 = ("Srinivas", 38, false)

tuple1.productArity


//In case of a function, we say that it's Arity is the number of
//input parameters for the function

val sq: Int => Int = (x : Int) => x * x  //Arity 1
val add : (Int, Int) => Int = (a : Int, b : Int) => a + b //Arity 2
val mult3 : (Int, Int, Int) => Int = _ * _ * _  //Arity 3

//this
val add2 : (Int, Int) => Int = (a : Int, b : Int) => a + b //Arity 2

//and this
val add1 : Function2[Int, Int, Int] = (a : Int, b : Int) => a + b

add1(1,2)

sq(1)
add.tupled(1,2)
mult3(1,2,3)

//At present scala stops at arity 22, this means we can only pass 22
//arguements in a function

//There are functions that have 0 Arity.

//they can be written as

val makeRandom : () => Double = () => Random.nextDouble()
makeRandom()

//this can also be written as
val makeRandom1 : Function0[Double] = () => Random.nextDouble()
makeRandom1()
