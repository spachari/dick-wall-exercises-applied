//Methods can be nested and very handy, but they still have to be named.

//A function literal (or lambda) is just a function (like a method) that may not have a name.
// It's defined by it's function, it's behaviour

//If we only use a function only once, the chances are we might use a function literal instead

//From the point of view of the caller, the syntax is actually interchangable
//For example

def multiplyMethod (x : Int, y : Int)= x * y

multiplyMethod(1,2)
//this can be converted to a function like this

(x : Int , y : Int) => x * y
//It does not have a name of it's own
//Scala just assigns the res0 name to it

//we can give a name and call it like how we would call a method
val multiplyFunction = (x : Int, y : Int) => x * y
multiplyFunction(1,2)

//So from a caller perspective, a method and a function are the same

//The other thing to notice is that, when we create this
//function
(x : Int, y : Int) => x * y

//we got this
//res3: (Int, Int) => Int = $Lambda$1211/1506226045@3a334556

//(Int, Int) => Int is the type
// and it also uses a rocket =>

//So we need to read it as,
//start with two Ints and combine them into an Int

//The implementation is a lambda  $Lambda$1211/1506226045@3a334556
//This project uses the java 8 lambda function handles or method handles
//this is much more efficient than an anonymous inner class

//scala 2.12 uses java 8 capabilities and that is why we see this
//toString (possibly the name of the literal) as a lambda $Lambda$1211

