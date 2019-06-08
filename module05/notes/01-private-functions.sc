import scala.annotation.tailrec
//In scala, we usually make a method private or protected so that it is used for implementation
//within our code and we don't want to expose it to users of the API
// In scala, the default scope is public. The other two are protected and private

//Private can be used within the code to simplify the code, split it up and structure it within the API
//but still provide a simple minimal calling into our code

//example

object Example01 {
  def makeList(x : Int) = recursiveListMaker(List.empty, x, 0)

  @tailrec
  private def recursiveListMaker(list : List[Int],
                                 listTill : Int,
                                 start : Int) : (List[Int], Int, Int) = {
    if (listTill > start) {
      recursiveListMaker(start + 1 :: list, listTill, start + 1)
    } else {
      (list, listTill, start)
    }
  }
}

object Example02 {

  def recursiveSum(x : Int) = recursiveSumList(List.empty, 10, 1, 0)._1

  @tailrec
  private def recursiveSumList(list : List[Int],
                               listTill : Int,
                               start : Int, total : Int) : (List[Int], Int, Int, Int) = {
    if (listTill >= start) {
      recursiveSumList(total :: list, listTill, start + 1, total + start)
    } else {
      (list, listTill, start, total)
    }
  }
}

val n = Example01

n.makeList(10)._1

val o = Example02.recursiveSum(10)


object Example03 {

  def recFibCalc(x : Int) = { recrusiveFibonacci(List.empty, 10, 2 , 1) }

  @tailrec
  private def recrusiveFibonacci(list : List[Int],
                         till : Int,
                         start : Int,
                         total : Int) : (List[Int], Int, Int, Int) = {
    if (start <= till) {
      recrusiveFibonacci(total :: list, till, start + 1, start * total)
    } else {
      (list, till, start, total)
    }
  }
}

val output = Example03.recFibCalc(10)

//This can be written very simply
//Two things to remember
//When we write a recursion function, we do not have to write
//1. both if and else condition to be the same return type, mostly
//the else will give a return type. That value must be of the return type
//2. In our case, we used a specific variable to calculate the total,
//always better to see if we can use the list.head or list.tail to calculate the return type

object Example03Alt {

  def factSeq(x : Int) = factSeqInner(List(1), 2, 10)

  @tailrec
  private def factSeqInner(list : List[Int],
                           start : Int,
                           end : Int) : List[Int] = {
    if (start > end) {
      list
    } else {
      factSeqInner(start * list.head :: list, start + 1, end)
    }
  }
}

val output1 = Example03Alt.factSeq(10)