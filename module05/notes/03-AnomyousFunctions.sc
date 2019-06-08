//A sample function literal

val multiplyFunction = (x : Int, y : Int) => x * y
//In this ecample, we have given the function the name of multiplyFunction so that we
// can easily identify it and call it later

//But if we are using it only once or a parameter to another method, there is no need to name it at all
//this is where lambda's really start to come into their own.

val list = (1 to 10).toList

list.map(x => x * x)
//we did not give a name for this function

//Another thing to notice in the function literal is that we had to mention that (x : Int, y : Int)
//This is because scala has nothing to infer what the types of x and y from. In order to call
//the function x * y, we had to tell the method that these are types of ints

//hence (x : Int, y : Int)

//These are the types (Int) that have multiply call on them "*"
//Otherwise scala compiler cannot ensure that what we are doing is correct.

//But if we have enough information to infer the lambda's types we dont need that anymore.

list.filter(x => x % 2 == 0)
//here, we know that the type of x is Int (from the list)
//filter's signature is (p : Int => Boolean)

//so we dont need to infer them

//So

val square = (x : Int) => x * x

//is the same as

list.map(x => x * x)

//square has a name and it's parameter has a return type, but list.map()
//does not have it because the name is not needed as it wont be used anymore
//and it's type is already infered

//We can mention if we want to

list.filter((x : Int) => x % 2 == 0)
list.map( x => x * x)

//we can also do something like
list.map(x => "hi" * x)

//In this case, we have changed the type the function to return a List[String]

//THis is where function literals come on their own.
//if these are not present, we will ahve to
// 1. iterate over the collection
// 2. do the calculation
//3. create a new collection and add them to our new collection

//we dont need to do these in scala, these are known as higher-order functions
//which are functions that take other functions and all we have to do is
//provide a function literal using this notation

list.map(x => x * x)

//x => x * x and it will do the job.


