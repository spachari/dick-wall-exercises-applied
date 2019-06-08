//
//Scala 2.12 has streamlined how things work in scala, but conceptually it is the same as scala 2.11

//if we create a function like this

val add : (Int, Int) => Int = (a :Int, b : Int) => a * b

//what will happen behind the scenes is a function class will be created

val add2 = new Function2[Int, Int, Int] {
  override def apply(a : Int, b : Int) = a * b
}


//this is the same as the apply we saw in the list

val list = List(1,2,3)

//being the same as callign it's apply method

val list1 = List.apply(1,2,3)

//The same way when we call

add2(1,2)

//because we call the instance and apply () after it. It will immedietely call the apply method

//Therefore if we make a class or instance that overrides apply ourselves, that will be invoked by a function call


//The other nomenclature is

//this is a function literal
val sub : (Int, Int) => Int = (a :Int, b : Int) => a - b

//this is a function value, all it is, is an instance of a new function
val sub1 = new Function2[Int, Int, Int] {
  override def apply(v1: Int, v2: Int): Int = v1 - v2
}


//Other notable methods that are created when a new function is called
//So when a function is created like this, scala generates some other methods that are useful to us

val mul: (Int, Int) => Int = (a : Int, b : Int) => a * b
//Type
//mul: (Int, Int) => Int = $Lambda$1316/192114340@217980fb
//This means it takes two Ints and converts it to an Int





//apply
mul.apply(2, 3)

//curried

val multCurried = mul.curried
//multCurried: Int => (Int => Int) = scala.Function2$$Lambda$1317/1280733645@70c5c3a2
//This means It takes an Integer, but it also produces an integer taking function
multCurried(2)(4)
multCurried(2)

//or
multCurried(2) (_)

//this si the same as
multCurried.apply(1).apply(4)

val mulCurryWithOneparameter = multCurried(2) //this will now create a function that takes 1 parameter
//mulCurryWithOneparameter: Int => Int = scala.Function2$$Lambda$1318/69719097@72de47ec
//This means it takes an Int and returns an Int

//Notice the types of each
val output = mulCurryWithOneparameter(4)



//tuple
//we can take this function that will accept a tuple of items
val tuple = (10,10)

val multOnTuple = mul.tupled

multOnTuple(tuple)
//type
//multOnTuple: ((Int, Int)) => Int = scala.Function2$$Lambda$1346/315219121@31ac3c1e

//it takes a single parameter, but that single parameter is a tuple of two items

//this wont compile
//mul(tuple)

//this is because the tuple is now a product of two things

