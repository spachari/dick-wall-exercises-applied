

import scala.annotation.tailrec


object Example03Alt {

  def factSeq(end : Int) = factSeqInner(List(1), 2, 10)

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

//Only in scala this method can be written like an inner method.


object Nestedmethod {

  def factSeq(end : Int) = {
    @tailrec
    def factSeqInner(list: List[Int],
                             start: Int,
                             end: Int): List[Int] =
    {
      if (start > end) {
        list
      } else {
        factSeqInner(start * list.head :: list, start + 1, end)
      }
    }
    factSeqInner(List(1), 2, 10)
  }
}

//We cannot mark factSeqInner as private anymore. It is inherently private. So there is no factSeqInner for the outer world.
//It is an implementation detail of factSeq

//All we did was just copy the method factSeqInner, just before factSeq's
//implementation and removed it private

val output2 = Nestedmethod.factSeq(10)

//See the point is that end is a variable in both the outer and
//inner method. The end method in the inner method takes precedence over the outer end.

//So by writing this way, we can also remove end in the inner method
//like this. The inner method will use the outer method's end variable too


object NestedmethodScoped {

  def factSeq(end : Int) = {
    @tailrec
    def factSeqInner(list: List[Int], start: Int): List[Int] =
    {
      if (start > end) {
        list
      } else {
        factSeqInner(start * list.head :: list, start + 1)
      }
    }
    factSeqInner(List(1), 2)
  }
}

val output3 = NestedmethodScoped.factSeq(10)