val x = 10

val y = 2.12

val name = "Fred"

s"$name $x $y"

s"$name is ${x * y}"

f"$name is ${x * y}%07.3f"
//The front part of (%07.3f) %07 will tell how many
//minimum characters should the total string be
//.3f will tell how many decimal places there should be

//If there is more than 3 digits in the front, we wont loose them

val z = 21212121.234

f"$name is ${x * z}%07.3f"
//See here it mentions the whole output even though we said
//total number of characters is 7

s"${name}'s"

//To include a " in a string we use """"""
//to make a string look nice in the code we can use .stripmargin

val s =
  s"""Here is a "string"
    | that contains two lines
    | also contains ${name}
  """.stripMargin

println(s)