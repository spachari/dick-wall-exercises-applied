def recursiveList(list : List[Int]) : List[List[Int]] = {
  list match {
    case x :: xs => list :: recursiveList(xs)
    case Nil => List(list)
  }
}

def recursiveListOtherWay(list : List[Int]) : List[List[Int]] = {

  if (list == List()) {
    List(list)
  } else {
    list :: recursiveListOtherWay(list.tail)
  }
}

val list = List(1,2,3,4)
recursiveListOtherWay(List(1,2,3,4))

recursiveList(list).reverse.tail.reverse
