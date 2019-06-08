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

