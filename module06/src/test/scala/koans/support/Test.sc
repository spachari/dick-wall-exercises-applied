import scala.io.Source

def withFileContents(string : String)(f : String => String): String = {
  val fileName = "/Users/spachari/Desktop/dickWall/exercises-applied/" + string
  val file = Source.fromFile(fileName)
  try {
    file.getLines().toSeq.headOption.map { line =>
      f(line)
    }.getOrElse("")
  } finally {
    file.close()
  }
}

withFileContents("quote.txt") { str => str.reverse }


val numList = List (-1, 0, -2, 3, -4, 5)

def countPositiveNumbers(list : List[Int], outputList : List[Int]) : List[Int] = {

  def recursiveListChecker() = {
    if (list.isEmpty) {
      outputList
    } else {
      if (list.head >= 0) {
        countPositiveNumbers(list.tail, 1 :: outputList)
      } else {
        countPositiveNumbers(list.tail, 0 :: outputList)
      }
    }
  }
  recursiveListChecker()
}

val output = countPositiveNumbers(numList, List())

output.sum
