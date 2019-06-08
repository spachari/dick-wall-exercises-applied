//Usually functions are left associated

5.-(2)

//Take 5 and applied -2 to it (left association) because
//whatever we do applies to the left hand side in infix form

//But any function that ends with a : is right associative
// if you write it in infix form

val list = Nil

Nil.::(1)

//Remember, :: will take a value and add it to it's head

4 :: List(1,2,3)

//So in this case

((Nil.::(1)).::(2))

//Start with Nil and
// apply 1 to it (put 1 to the head of that)
// and then applied to 2 (put 2 to the head of the list)

//Check if there is any difference between

((Nil.::(1)).::(2))

//the below is left associative
//Nil is applied to 2 and then 1
1 :: 2 :: Nil


//Another right associative method (in infix form) is

val list1 = List(1,2,3)

val list2 = List(4,5,6)

//left associative
list1 ::: list2

//Right associative
list2.:::(list1)
