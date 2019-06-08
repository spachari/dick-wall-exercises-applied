//Why Var args

//Have we wondered how it is possible in scala to create a list like this in scala

val list1 = List(1,2,3)
val list2 = List(1,2,3,4,5)

//if it uses the normal list.apply method, then we should have a million list methods

/*
object Listx{
  def apply(x : Int) = Listx(x)

  def apply(x : Int, y : Int) = Listx(x,y)
}
*/

//but that is not what happens
//In scala we have a concept called varargs. It is usually denoted by type followed by a star. Example String*

def sayHello(names : String*) = {
  for (name <- names) println(name)
}

//we can call it with any number of strings
sayHello("Srinivas")
sayHello("Srinivas", "Shankar", "Sachin")
sayHello()

//what happens is the JVM parses varargs as a Array[String]
//we can visit each of the elements individually and print them out

//varargs need not be the only parameter in a method, but
//it has to be the last arguement in the method

def greetFriends(greeting : String, names : String*) = {
  for (name <- names) yield {
    s"$greeting $name"
  }
}

greetFriends("Yo", "Srinivas","Shankar","Sachin")
greetFriends("Yo") //because it is an array of string, not parsing anyting is ok

//but we cannot do this
//greetFriends()

//how do i pass an existing collection in to varargs parameter

val names = List("Srinivas","Shankar","Sachin")

//the below wont work
//greetFriends("Yo", names)
//it says, "expected String, actual List[String]"

//Solution 1 - we can write an overloaded greetFriends method that takes a List[String]

/*
def greetFriends(greeting : String, namesList : Seq[String]) : Seq[String] = {
  for ( name <- namesList) yield s"$greeting $name"
}

greetFriends("Yo", names)
*/

//But scala cannot disambiguate the two methods after type erasure
//they both have the same type
/*
Error:(50, 6) double definition:
def greetFriends(greeting: String,names: String*): Seq[String] at line 32 and
def greetFriends(greeting: String,namesList: Seq[String]): Seq[String] at line 54
have same type after erasure: (greeting: String, names: Seq)Seq
def greetFriends(greeting : String, namesList : Seq[String]) : Seq[String] = {
    ^
 */

//SO all we need to do is
greetFriends("Yo", names : _*)

//: _* is an expansion operator, it will convert the
//List[String] to String* varargs

//we see this in recursion over varargs methods
//Note that eventhough we said varargs is converted to Array[String] by JVM
//the output retains the original collection type (List)