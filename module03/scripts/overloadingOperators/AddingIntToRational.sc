class Rational private(val n: Int, val d: Int) {
  require(d != 0, "Zero denominator!")

  override def toString: String = s"R($n/$d)"

  def min(other: Rational): Rational =
    if ((n.toDouble / d) < (other.n.toDouble / other.d))
      this else other

  def +(other: Rational): Rational =
    new Rational(
      this.n * other.d + this.d * other.n,
      this.d * other.d
    )

  def +(i : Int) : Rational = {
    new Rational(this.n + i * this.d, this.d)

    //even better
    this + Rational(i)
  }
}

object Rational {
  def apply(i : Int, j : Int) = new Rational(i,j)

  def apply(i : Int) = new Rational(i, 1)
}

val half = Rational(1, 2)
val fifth = Rational(1, 5)

val smaller = fifth min half

val sum = half + fifth

//val divByZero = Rational(1, 0)

val halfPlusThree = half + 5