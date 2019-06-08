class Demo

class DemoWithFieldsAndMethods {
  val x = 10
  val y = x * 2

  def timesY(a: Int): Int = a * y
}

val demoWithFieldsAndMethods = new DemoWithFieldsAndMethods

demoWithFieldsAndMethods.x
demoWithFieldsAndMethods.timesY(4)

class DemoWithParams(name: String) { //name is the primary constructor
  println(s"Constructing for $name") //Anything that is not in defs are constructor class

  def sayHi(times: Int): Unit = {
    var time = 0

    while (time < times) {
      println(s"Hi, $name")
      time += 1
    }
  }
}

val demoWithParams = new DemoWithParams("Zoe")

demoWithParams.sayHi(5)

// can't access the name from outside:
// demoWithParams.name
//because by default constructor scope is private

//The only way to access constructor is by calling them from outside
class Animal(name : String) {
  val animalname = name //this now makes the name to be accessible anywhere
}

val animal = new Animal("Dog")

println(animal.animalname)

//The best practice of creating a field as constructor and making it public in scala is
//by declaring it with val

class Fish(val name : String) {
  println(s"Fish name is $name")
}

val fish = new Fish("Goldie")

println(fish.name)

//What scala does internally is it creates something like this
//class Fish(_name : String) { //parameter is private[this]
//  val name = _name
//  println(s"Fish name is $name")
//}

