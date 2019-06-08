class Rational (val n : Int, val d : Int) {
  require(d != 0, "Cannot have dinominators as 0") //require takes two arguements (a boolean, a string). The idea is if it fails,
  //we fail it immedietely

  //Auxillary constructor
  def this(i : Int) = this(i, 1)
  //we create it exactly like how we would create a method
  //but we say def this() (this = refering to the current instance).
  // It is the only way to create an auxillary constructor
  // It needs to be different from the standard constructor (or scala cannot differentiate between the primary and the auxiallary constructor)
  //The only thing an auxillary constructor can do is call another constructor (it cannot do anything else)
  //Any logic should be deployed to this() call
  //No need to provide return type.



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

val oneHalf = new Rational(1, 2)

val twoFifth = new Rational(2,5)

oneHalf.min(twoFifth) //this is infix

oneHalf min twoFifth

oneHalf + twoFifth

oneHalf + new Rational(1)

