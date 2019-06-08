//A closure is so-called becuase it encloses some other state than that is passed into it's function literals

//All closures are function literals but not all function literals are closures

val add = (x : Int) => x + 10 //this function literal is not a closure
//because the only variables that are used here are passed into the function

val more = 10
val addMore = (x : Int) => x + more//this function literal is a closure
//because it depends on variable more as well, which is defined outside this function.

//What happens is the function literal grows a handle and sucks
//variable more into it.

//The process of bringing a state from outside and enclosing it into the function literal


//Do not use closures with vars it will be confusing and will break the referential integrity

var more1 = 10

def addMore1(x : Int) = {
  more1 = more1 + 1 //enclosing more1 from outside the function
  x + more1
}

addMore1(10)
addMore1(10)
addMore1(10)

//Remember, the principle of functional programming is that every
// time you use a function with a variable the output will be the same

//this means it ensures referential transparency. Using vars
//will defeat the purpose. so it is not best practice to use vars with
//closures