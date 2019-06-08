//All method parameters have names, so that we define them by name and use them.
//For example

def greet(personName : String) = { //the method parameter name is personName
  println("Hello " + personName)  //we use the name of the parameter here
}

//we can call the method outside with the parameter name like this

greet(personName = "Srinivas")

//It is a bit more useful
// 1. when we have more than one parameter
// 2. and it is more useful when you use it in conjunction with another feature in scala

//Named parameters
def thingy(name : String, age : Int, isCold : Boolean, isBroken : Boolean) =
  s"name $name age $age isCold $isCold isBroken $isBroken"

//this does not tell much about the methods
thingy("toy", 4, true, false)
thingy(name = "toy", age = 4, isCold = true, isBroken = false) //is more readable

//the advantage is that even if we change the order, it will still work

thingy(isCold = true, isBroken = false, name = "toy", age = 4)

//Default parameters
def gravity = 9.81

def force(mass : Double = 1, acceleration : Double = gravity) = {
  mass * acceleration
}

//we can call the method in all these ways
force()
force(mass = 12)
//not particularly readable

force(acceleration = 2 * gravity)
force(acceleration = gravity / 13.0, mass = 12.9)

//we can use it nicely along with features like recursion

//here the default value for list is List(1) and start is 2

def factSeq(counter : Int, list : List[Int] = List(1), start : Int = 2): List[Int] = {
  if (counter < start) {
    list
  } else {
    factSeq(counter, start * list.head :: list, start + 1)
  }
}

//we can call the method like this
factSeq(7)


def echo(args : Int*) = args.foreach(println)

echo(1,2,3)