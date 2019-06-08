import scala.io.Source
//There are two parts to a for expression
//   1. For block
//   2. yield block

val fileNames = new java.io.File("/Users/spachari/Desktop/dickWall/exercises-applied/module04/scripts/notes").listFiles()
val output = for {
  file <- fileNames
  if file.getName.endsWith(".sc")
  line <- Source.fromFile(file).getLines()
  trimmedLine = line.trim
  if trimmedLine.contains("write")
} yield (file, trimmedLine)

output.foreach{case(x,y) => println("FileName " + x + " content " + y)}

//Within the for block, we have the 4G's

//Generators: file <- fileName, denoted by the <-,
// all generators in the same block must be of the same type (a collection or a Type e.g. Try, Option).

//Guards: if file.toString.endsWith(".sc"), guards short circuit the for loop and give filtering behaviour
//if the condition/predicate is true, the for expression continues, if not it will come out for that particular collection and basically
// goes no further.

//inline assiGnment: trimmedLine = line.trim, a simple val assignment that can be used both in the for block and in the yield block

//give block: yield part after the for block

//Scala will re-write the code block into normal functional code as below


val output1 = fileNames.filter(scalaFile => scalaFile.getName.endsWith(".sc")).flatMap(file =>
                      Source.fromFile(file).getLines()).filter(f =>
                           f.contains("write")).map(line =>
                                line.trim)

output1.foreach(println)


val output2 = fileNames.filter(scalaFile => scalaFile.getName.endsWith(".sc")).flatMap(file =>
  Source.fromFile(file).getLines()).filter(f =>
  f.contains("write")).map(line =>
  line.trim)

val mapTest = (1 to 10).toList.map(x => (x.toString, x * 2))
  .foreach{ case (x,y) => println(x, y)}