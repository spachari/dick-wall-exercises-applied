//Placeholder can be used to write functions in a simpler way

//in function literals we assign a function once and use them
val nums = (1 to 10).toList

nums.filter(_ < 4)
nums.filter(x => x < 4)


nums.span(x => x % 4 != 0)
nums.span(_ % 4 != 0)

nums.partition(x => x % 4 == 0)
nums.partition(_ % 4 ==0)

//we just replaced x => x with _, we read _ as "the thing" (that comes into the function)

//Rules around placeholder syntax
//1. We can use the placeholder syntax if the variables are used only once and in the same order

nums.map(x => x * x)

//cannot be written as
//nums.map(_ * _)
//because the single parameter cannot be used twice

//let's use the placeholder syntax on multiple variables

def compareFunction(list : List[Int], compare : (Int, Int) => Int) = {
  for (pair <- list.sliding(2)) yield {
    compare(pair(0), pair(1))
  }
}.toList

compareFunction(nums, (a, b) => a + b)

//can be written in placeholder notation because
// 1. the variables are used in the same order
// 2. and they are used only once

compareFunction(nums, (_ + _))


//But this function
compareFunction(nums, (a,b) => (a - b).abs)

//cannot be written in placeholder notation because
//(_ - _).abs cannot be written

//We can explicitly specify the types of our placeholders
//for example

compareFunction(nums, (a,b) => a + b)

//in this case scala can infer the types, but we can also explicitly mention the types as

compareFunction(nums, (a : Int, b : Int) => a + b)

//we can do the same for our placeholders too

compareFunction(nums, (_ + _))

//can be written with place holders like this

compareFunction(nums, ((_ : Int) + (_ : Int)))

//(_ : Int) this is placeholder syntax to say, "it's something that is an Int"

//where this syntax becomes mandatory is when we create a function literal like this

val adder = (_ : Int) + (_ : Int)

//here the type is mandatory because scala has no way of knowing we are going to
//use the type that contains the + method

compareFunction(nums, adder)

//we can use it multiple times

//all being said, the adder is better written like this

val adder1 = (a : Int, b : Int) => a + b
