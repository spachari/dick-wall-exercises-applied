//Higher order functions are functions (or methods) that take a (function literal)
// or return other functions

//functions that take another functions
val nums = (1 to 10).toList

nums.map(x => x * x)

nums.span(x => x > 4)

nums.partition(x => x % 4 == 0)


//all the above are map, span and partition are functions that take another function

//Functions that return other functions
val mulitplyBy : (Int, Int) => Int = (a : Int, b : Int) => a * b

val multiplyBy2 = mulitplyBy(2,3)

//Another way of doing is
val mult :Int => (Int => Int) = (a : Int) => a * _
//This takes an int that gives a function that takes an int and gives out an int

val multBy2 = mult(2)

val answer = multBy2(3)



//if a method or function that does not take or return a function are
// called first order function

//Example of a higher order function
def compareNeighbours(list : List[Int], compare : (Int, Int) => Int) = {
  for (pair <- list.sliding(2)) yield {
    compare(pair(0), pair(1))
  }
}.toList

compareNeighbours(nums, (a,b) => a + b)

compareNeighbours(List(4,1,7,8,12,4), (a,b) => (a - b).abs)

//This is possible only because we wrote a higher order function that takes
//a variable that is a function literal. This is really the power of
//functional programming, which is having functions as first class concept,
//which is just like another piece of data (variable) that we can pass into
//other functions and let them do the work


//the above function can be written as
def compareFunction1(list : List[Int], compare : Function2[Int, Int, Int]) = {
  for (pair <- list.sliding(2)) yield {
    compare(pair(0), pair(1))
  }
}.toList

//So (Int, Int) => Int can be written as new Function2[Int, Int, Int]
