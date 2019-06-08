def multiply(anyNumber : Int) = {
  val list = List(1,2,3,4,5,6,7,8,9,10)
  list.map(x => (x, x * anyNumber)).foreach{ case (x,y) => println(s"${x} * ${anyNumber} = ${y}")}
}

multiply(14)

multiply(20)