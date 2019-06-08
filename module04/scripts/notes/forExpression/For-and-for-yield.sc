//For expression is something that works on a container without us needing to worry about what kind of container it is.

//If that container is a
              // 1. Sequence it will iterate though them.
              // 2. Option it will unwap it and parse them (either 0 or something).
              // 3. It will also work on Try (another kind of container that will contain Success or Failure)
              // 4. It will work on Futures (concurrent programming)
              // 5. It will do it on our own types as well.

//We can use the for loop in them without caring about what the outer type is


//foreach
for (i <- 1 to 10) println(i * i) //result is a Unit

//Behind the scene, it turns the code into a  range (1 to 10)

(1 to 10)

//and apply the foreach on the range

(1 to 10).foreach(i => println(i * i))



//this is a way to iterate multiple foreach loops
for (i <- 1 to 3; j <- 1 to 3) println(i * j)

//behind the scenes this is converted as a foreach within a foreach
(1 to 3).foreach(i => (1 to 3).foreach(j => println(i * j)))

//Note => is called a "function operator"
//Note <- is called a generator

//Another way of writing the above is

for {i <- 1 to 3
     j <- 1 to 3
} println(i * j)

//The {} style gives semi-colon inference. That is one of the differences between
//paranthesis style () and curly braces style {} of writing code

//This is for as a statement. It just acts as a foreach and results in a Unit

//For with yield, it acts as a map/flatMap run over the tops of it
//and will return a collection


//Map
val squares = for (i <- 1 to 10) yield i * i

//This is a proper functional style of programming. i.e. it gives us a
//functional construct.

//This converts the code behind the scenes to a map on the range (1 to 10)

val output = (1 to 10).map(x => x * x)

//Note the output is a IndexedSeq[Int] a Vector
//Note aso that a Range is an arithmetic progression which will give up from being a range
//once it knows that it is followed by a map and both Vector and Range are
//an IndexedSeq[]. So conversion becomes easy

//FlatMap
val flatMapOutput = for {
  i <- 1 to 3
  j <- 1 to 3
  k <- 1 to 3
} yield i * j * k


//This is converted behind the scenes to

val flatMapOutput1 = (1 to 3).flatMap(x => (1 to 3).flatMap(y => (1 to 3).map(z => x * y * z)))

//So yield is map
// just println is foreach
// two three generators is flatMap

