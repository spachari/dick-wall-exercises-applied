

val maxSoFar = Int.MinValue
def max(numbers : List[Int]) = {

  def findMax(numbers : List[Int], max : Int) : (List[Int], Int) = {
    print(numbers + " max " + max)
    println()
    numbers match {
      case Nil => (numbers, Int.MinValue)
      case x :: Nil => if (max > x) (numbers, max) else (numbers, x)
      case x :: xs => if (max > x) findMax(xs, max) else findMax(xs, x)
    }
  }

  val number = findMax(numbers, Int.MinValue)
  number._2

}


max(List(10, 1, 4, 5, 3, 2))
max(List(5, 3, 2, 1, 4))
max(List(-5, -1, -3, -2))
max(Nil)


var shksprMap = new scala.collection.mutable.HashMap[Integer, String]

val myMap = Map(1 -> "a")
val list = List(1,2,3,4)

val listWithAlphabets = for {
  i <- list
} shksprMap.put(i, "a")

//list.foreach{ case x => shksprMap.put(x, "a")}

shksprMap.foreach{ case (x,y) => println(x + " " + y)}


val shksprMap1 = new scala.collection.immutable.HashMap[Integer, String]

val myMap1 = Map(1 -> "a")
val list1 = List(1,2,3,4)

val listWithAlphabets1 = {for {
  i <- list
} yield (i -> "a") }.toMap


//list.foreach{ case x => shksprMap.put(x, "a")}

listWithAlphabets1.foreach{ case (x,y) => println(x + " " + y)}