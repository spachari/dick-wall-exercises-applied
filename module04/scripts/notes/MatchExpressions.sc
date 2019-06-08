//Match is an expression which is basically a set of branches based on possible branches

//It's return type is the least upper bound or the most specific type that will
//represent all of the possibilities

//We can also use it as a statement too if all possibilities return Unit

val x = 1

//match expression as a statement
x match {
  case 1 => println("One")
  case 2 => println("Two")
  case _ => println("Not one or two ... ") //this is the default case
                                           //it means that match anything that has not been matched above
}

//match expression as an expression
val res = x match {
  case 1 => "one"
  case 2 => "two"
  case _ => "Unsure ..."
}

println(res)


//Points to note:
//Match goes through matching conditions from top to bottom and once it finds a match it does
//whatever is mentioned after the => (rocket) and exits

//There is no automatic fall through
//it matches them in order and the first one to match will consume the entire pattern match


//Guards in match expression

    def matchingNumbers(x : Int) = {
      x match {
        case n  if (n < 0) => s"${n.abs} is negative" //what this does it takes x
                                                      // and puts it into n (val) and then
                                                      // checks if it is greater than 0 that is the guard
        case 0 => "zero"
        case n => s"${n} is positive" //here x is put in n and there is no need to check
                                      //if n > 0 because all other possibilities are already checked
      }
    }

val y = 10
val z = -10
val a = 0

println(matchingNumbers(y))

println(matchingNumbers(z))
println(matchingNumbers(a))

//guard and assignment in for comprehension

val output = for {
  i <- 1 to 10
  if (i % 2 == 0)
  output = i
} println(output)

//Pattern matching on lists

def matchIf(x : Any) = {
  x match {
    case "Hello" => "Well, hello back"
    case 1 :: rest => "A list starting with 1"
    case Nil => "An empty list"
    case 5 => "The number"
    case _ : List[_] => "Some kind of list is a list of anything"
    case anythingElse => s"Default value ${anythingElse}"
  } // if it reaches to the end, we will get a pattern matching error
}

matchIf(5)
matchIf(List(1,2,3))
matchIf(List(1))
matchIf(List(2,3))
matchIf(2.0)

