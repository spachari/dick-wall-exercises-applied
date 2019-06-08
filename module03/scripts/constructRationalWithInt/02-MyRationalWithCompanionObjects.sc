class Rational private (val n : Int, val d : Int) { //This is how we make constructor private
  require(d != 0, "Cannot have dinominators as 0") //require takes two arguements (a boolean, a string). The idea is if it fails,
  //we fail it immedietely



  def min(other : Rational) : Rational = {
    if ((n.toDouble / d) < (other.n.toDouble / other.d))
      this else other //in scala the current instance
    // can be referenced by keyword this
  }

  def +(other : Rational) : Rational = {
    new Rational((n * other.d) + (other.n * d), d * other.d)
  }

  override def toString: String = s"R($n/$d)"
}

/*
  Companion objects: An object in the same source file with the same name as the class (or trait)

  Shares private state (fields and methods) and behaviour with the class (equal to java's static)

  Good place to add factory methods (apply(), update())
*/

object Rational {
  def apply(n : Int, d : Int) : Rational = {
    println("Creating our auxillary constructor")
    new Rational(n,d) } // this is a factory method

  def apply(n : Int) : Rational = new Rational(n, 1)
}

val oneHalf =  Rational(1,2)

val twoFifth =  Rational(2,5)

val one = Rational(1)

oneHalf + twoFifth

//advantages:

//1. We can do pretty much anything along with our constructor
// creation

//2. We can overload the factory methods with other factory methods

//3. They are invoked without using the new keyword

//4. It get's re-written with Rational.apply(1)

//5. Companion object can access the private constructor
//This means we cannot do the following
//val ones = new Rational(2)

//We can only do this
val ones = Rational(2)

//We can use this design pattern
// (make primary constructor private and force everyone to use the factory methods)
// if we need the constructor
//to do some useful work like
// 1. creating a db instance
// 2. calling a webservice
// before creating the instance we can do this (our design choice)

//Hence factory methods and private constructors are often idiomatic ways to use scala