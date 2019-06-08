//partial application is nothing but creating a higher order function that takes a value,
// by only passing half of the values only

val multiply = (a : Int, b: Int) => a * b

val multiplyBy5 = multiply(5, _: Int)

//Remember, we need to provide the type _: Int for the partially applied function
//scala wont infer it

val twoMultiply5 = multiplyBy5(2)

val multiplyBy2 = multiply(2, _: Int)

val fiveMultiplyBy2 = multiplyBy2(5)


//Example

val addFunction = (a : Int, b : Int, c : Int) => a + b + c

val add4And7 = addFunction(4, _: Int, 7)
//at this point, 4 and 7 are bounded to the partially applied function
// we can say that the two values 4 and 7 are binded to the function

val total = add4And7(7)

//================================================================
//we can do this def too
def addMethod(a : Int, b : Int, c : Int) = a + b + c

val add4And8 = addMethod(4, (_: Int), 8)

val total1 = add4And8(9)

//what we can also do is partially apply all functions like this

val add3Function = addMethod(_,_,_)

//in this place, we dont need to produce any type, scala can infer the type

add3Function(1,2,3)

//or we can also do

val add4Function = addMethod _

//Note : when there is a place holder after a method,
//it is because NONE of the arguements are given

add4Function(2,3,4)

//Let's use the above partially applied functions

def compareTriplets(list : List[Int], compare : (Int, Int, Int) => Int) = {
  for (triplets <- list.sliding(3)) yield {
    (triplets(0), triplets(1), triplets(2))
  }
}.toList

val nums = (1 to 10).toList
compareTriplets(nums, add3Function)
compareTriplets(nums, add4Function)
compareTriplets(nums, addMethod) //eta expansion

//what we have done is, we have passed a method in the case of a function
//what happens in this case is the method is converted into a function

//The point is, we can use functions and methods interchangably without
//having to worry about converting them for a specific use in scala

//let's test and see if it works
def twoInts(f : (Int, Int) => Int, a : Int, b : Int) = f(a,b)

val add = (a : Int, b : Int) => a + b

twoInts(add _, 5, 10)

//This is the difference between def and val (function literal)
//a function literal can be passed around like it is a value but a def can also be
//but the problem is that a function literal can be an arguement,
//a def cannot be in an arguement