import java.io.PrintWriter


//We can always return this instead of Unit to chain our function calls
class WriterOutput(writer : PrintWriter) {
  def write(x : Any) = writer.println(x)
}

//We can do these folloign things
val ex1 = new PrintWriter("/Users/spachari/Desktop/dickWall/exercises-applied/module04/scripts/notes/output.txt")
val writer = new WriterOutput(ex1)

writer.write("Hello")
writer.write("Sadhana")

ex1.close()
//Convention is to put () on a zero parans method that returns a side effect
//That's the tip off for the reader of the API, that the statement has a side-effect


//if we return this instead in the above example, we get a fluent API
class WriterOutput1(writer : PrintWriter) {
  def write(x : Any) = {
    writer.println(x)
    this
  }
}

//If we use this now, once we use the write method, it writes the output and
//it returns the same instance again, which means we can immedietely call another
//write method on it

val ex2 = new PrintWriter("/Users/spachari/Desktop/dickWall/exercises-applied/module04/scripts/notes/output2.txt")
val writer2 = new WriterOutput1(ex2)

writer2.write("Hello").write("Sadhana")
//We can always choose to ignore the output if we choose to, even though
//it returns WriterOutput1 instance, we simply ignored it after the
//job is done

ex2.close()

//We dont get any referential integrity or anyting like that, but we do get
//a slightly more fluent API to write things out.

//We could even say
val ex3 = new PrintWriter("/Users/spachari/Desktop/dickWall/exercises-applied/module04/scripts/notes/output2.txt")
val writer3 = new WriterOutput1(ex3)

writer3.write("Hello").write("Srinivas")

ex3.close()