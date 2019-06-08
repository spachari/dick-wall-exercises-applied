import java.io.File

import scala.io.Source
//We can now re-write our function


def workWithFirstLineOfFiles[A](filename : File, f : String => A, default : A) : A = {
  val source = Source.fromFile(filename)
  try {
    source.getLines().toList.headOption.map{
      line => f(line)
    }.getOrElse(default)
  } finally {
    source.close()
  }
}

//to this

def workWithFirstLineOfFiles[A](filename : File,  default : A)(f : String => A) : A = {
  val source = Source.fromFile(filename)
  try {
    source.getLines().toList.headOption.map{
      line => f(line)
    }.getOrElse(default)
  } finally {
    source.close()
  }
}

//This is called loan-pattern, because, we manage the resource, a file in this case,
// i.e. take care of opening and closing the resource and loan it to the function that wants to use it
//The function is able to use it without having to think about whether it cleans it up or not

//This is like an arm block in java. It is a built in feature of functional programming languages
// (languages that have functions as first class citizens). We can do this kind of loan in them.

//we can call the function like this

val hamlet = new File("/Users/spachari/Desktop/dickWall/exercises-applied/" + "hamlet.shkspr")

workWithFirstLineOfFiles(hamlet, "")(_.trim.toUpperCase)
workWithFirstLineOfFiles(hamlet, false)(_.trim.endsWith("?"))

workWithFirstLineOfFiles(hamlet, 'e') { line =>
    val letter = line.toLowerCase.filterNot(_ == ' ').toSeq
    val group = letter.groupBy(identity)
    group.maxBy { case(letter, seqs) => seqs.length}._1
}

//this looks more nicer when it comes to functional programming