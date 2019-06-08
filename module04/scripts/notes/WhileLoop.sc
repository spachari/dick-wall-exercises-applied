import scala.annotation.tailrec
//In scala while loop and do ... while are statements

//So they are used only for some side effects

def greet(string : String) = {
  var i = 5
  while(i > 0) {
    println("Hello " + string)
    i = i - 1
  }
}

//When we use while loop, there has to be a mutability or variables
// or either the while loop will never run or always run

greet("Srinivas")

//same program in functional way

@tailrec
def times(string : String, cur : Int = 0) : Unit = {
  if (cur > 0) {
    println("Hello " + string)
    times(string, cur - 1)
  } else ()
}

//here if the last statement of the function is a call to itself
//scala obtimizes the code to a while loop internally without
//us having to do it and we can get any return type for this function


times("Srinivas", 5)