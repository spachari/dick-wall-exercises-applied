
//The return type of Scala expressions are always the least common return type
// (most specific super type) for both sides involved in the comparision

//if statement

var x = true
val y = 10

val output = if (x) x else y

println(output)

//even if we change x to be false
x = false

val output1 = if (x) x else y

println(output1)

//So the result of an expression is whatever the branch of the code
//that is passed to it based on the predicate (condition)

//But the return type is established by comparing both sides and the most specific
//common supertype of both sides is set

//Same way in the case of try catch block the type is calculated by
//the type of the try block and the type that comes back from the catch block

//This is because if the try works, we will get whatever is there in the
//try block and if it does not work, whatever in the catch block will be executed

//an example

val array : Array[String] = Array.empty

val fileName = try {
  array.head
} catch {
  case _ : NoSuchElementException => "default.txt"
} finally {
  println("The file name is sorted")
  //s"$array"
}

//The finally block always runs either way and it's type is irrelevant.
//It is just used to complete the purpose of what started the expression in the
//first place. Like close a file and stop a db connection.

//Only the try and catch blocks return type are considered for establishing the
//type of the expression. Finally's type is not considered

println(fileName)

//Another example

val x1 = true
val output3 = try {   //It's type is AnyVal
  require(x1, "x1 should be true")
  x1
} catch {
  case _ : IllegalArgumentException => 0
}

println(output3)

