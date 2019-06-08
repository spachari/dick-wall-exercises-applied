class Rational private (val n : Int, val d : Int) {
  require(d != 0, "Fractions cannot have dinominators of 0 value")

  def +(other : Rational) : Rational = {
    new Rational (n * other.d + d * other.n, d * other.d)
  }

  def +(i : Int) : Rational= {
    this + Rational(i)
  }

  override def toString: String = s"R($n/$d)"
}

object Rational {
  def apply(i : Int, j : Int) = new Rational(i, j)

  implicit def apply(i : Int) = new Rational(i, 1)
  //we are telling scala that this is the way to add an implicit to scala
  //This gives the ability to convert an integer to Rational
}

val half = Rational(1,2)

3 + Rational(1,2)
//What scala does in this situation is, it goes and looks at both places
//1. Int
//2. Rational

//and thinks "I dont know how to add an Int to a Rational() or Rational() to an Int.
//Maybe there is an implicit that can solve my problem"

//So it does the following
//1. It looks for an implicit that is generally available
//2. It will look in the companion objects for Int
//3. It will look in the companion onbjects for Rational

//So in a method, when there are two types that are meant to be used, we should know
//that scala looks for
// 1. general implicit def (or in predef)
// 2. implicit def in either companion objects

//Yes, when there is a type error in the scala code, before the compiler gives
// up, it looks to see if there is an implicit conversion (or parameter) that
// can solve the problem, that is marked as implicit and in the current scope,
// and if there is it will use that to correct the type error and make the
// code compile correctly.

