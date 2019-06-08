//Currying

//a function when created gives us curried values
val add3 : (Int, Int, Int) => Int = (a : Int, b : Int, c : Int) => a + b + c
//add3: (Int, Int, Int) => Int = $Lambda$2711/345502358@1e302a4

//so we saw that this gives a curried function
val add3Curried = add3.curried
//It's type will be
//add3Curried: Int => (Int => (Int => Int)) = scala.Function3$$Lambda$2713/990944030@7f62654a

//The idea of currying is, instead of providing all parameters in one
//parameter list, wwhen we provide one parameter and it will return a
// function that takes another parameter, when we provide that parameter
// which in turn provides a function
// that takes another parameter.

//we can write this function ourselves

val add3c : Int => Int => Int => Int = a => b => c => a + b + c

//this is how we can call all three functions
add3(1,2,3)
add3Curried(1)(2)(3)
add3c(1)(2)(3)
//

//we can curry them like this too

val addWithOneAndTwo = add3c(1)(2)

addWithOneAndTwo(3)

//what happens is each time the function is called it's apply method is called
//which gives a function that takes an Int

add3c.apply(1)
//res4: Int => (Int => Int) = $Lambda$2727/1202251564@7397fd2d
//type is it takes an Int and gives an (Int => Int)

add3c.apply(1).apply(2)
//res5: Int => Int = $Lambda$2732/1394436829@73afe6fd
//type is it takes an Int and gives and Int

add3c.apply(1).apply(2).apply(3)

//A function like this
add3c(1)(2)(3)

//can be written like this
add3c{1}{2}{3}

//this is possible only when inside the paranthesis
// there is only one variable

val addTwo : (Int, Int) => Int = (a : Int, b : Int) => a + b

addTwo(1,2)

//this cannot be written like this
//addTwo{1,2}


//the difference between parans () and curly braces is {}
//1. () can have , i.e. multiple parameters but {} cannot
//2. semi colon inference is turned on inside {} but not in ()

//This trick is useful for cleaning up our generic implementation