import scala.io.Source

//Point sto note in this code
//1. a finally cannot access try variables. If it has to access the variables, declare it outside of the try block
//2. a map can open Option[] and it will give you an Option[]
//3.

def isFirstLineQuestion(fileName : String) : Boolean = {
  val source = Source.fromFile(fileName)
  try {
    source.getLines().toList.headOption.map {
      x => x.endsWith("?")
    }.getOrElse(false)
  } finally {
    source.close()
  }
}

def upperCaseFirstLine(fileName : String) : String = {
  val source = Source.fromFile(fileName)

  try {
    source.getLines().toList.headOption.map {
      x => x.toUpperCase()
    }.getOrElse("")
  } finally {
    source.close()
  }
}

val fileList = List("caesar.shkspr", "hamlet.shkspr","romeo.shkspr")
val directory = "/Users/spachari/Desktop/dickWall/exercises-applied/"
for (file <- fileList) {
  val fileWithDirectory = directory + file
  println(file + " " + isFirstLineQuestion(fileWithDirectory))
}

for (file <- fileList) {
  val fileWithDirectory = directory + file
  println(file + " " + upperCaseFirstLine(fileWithDirectory))
}


//both the methods can be written by using generics and higher order functions
def workWithFirstLineOfFiles[A](filename : String, f : String => A, default : A) : A = {
  val source = Source.fromFile(filename)
  try {
    source.getLines().toList.headOption.map{
      x => f(x)
    }.getOrElse(default)
  } finally {
    source.close()
  }
}

//[A] - is generic type parameter, we are going to add in some type that we dont know what it is
//yet, for now we call it some type. It will be provided when the function is provided.

//f : String => A - We are going to take this function whose type is from String, it will
//be converted into A. In other words, the function will take a Strign and convert it into
//A. This is just a function literal. So this function is a HoF

//default : A - also we are going to set the default getOrElse type if there is going to be no
// line in the file

//: A - the return type of the function will be the generic type which we dont know,
// but will be provided

//workWithFirstLineOfFiles[A] - is a parameter to the function, except it is a type parameter
//it is a type that we are passing in and in many cases scala can infer this.

//USING THE HoF

val file = "/Users/spachari/Desktop/dickWall/exercises-applied/" + "hamlet.shkspr"
workWithFirstLineOfFiles(file, _.trim.endsWith("?"), false)

workWithFirstLineOfFiles(file, _.trim.toUpperCase, "")

//(_.trim.endsWith("?")) - we use the place holder syntax, it means,
// "the thing" that ends with "?"

//we can do something more complex if we want to calculate the most number of occurances of a letter

workWithFirstLineOfFiles(file, line => {
  val letters = line.trim.toLowerCase.filterNot(_ == " ").toSeq
  val grouped = letters.groupBy(identity)
  grouped.maxBy{ case (char, seq) => seq.length }._1
}, 'e')

//The complex function can be explained below
val string = "Srinivas Pachari"
val output = string.filterNot(_ == ' ').groupBy(identity) //it converts a List[Char] to a Map(k, v)
                                      // gives a map of key, value pair
//filterNot(_ == ' ')

val finals = output.maxBy{ case(letter, seq) => seq.length } //take the max

