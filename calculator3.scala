def calculation3(three: (Int, Int, Int) => Int){
	three(x3, y3, z3)
}

def addition3(a:Int, b:Int, c: Int):Int ={
	var x = (a + b + c)
	println(a + " + " + b + " + " + c)
	println("Result: " + x)
	println
	return x
}

def subtraction3(a:Int, b:Int, c: Int):Int ={
	var x = (a - b - c)
	println(a + " - " + b + " - " + c)
	println("Result: " + x)
	println
	return x
}

def multiplication3(a:Int, b:Int, c:Int):Int ={
	var x = (a * b * c)
	println(a + " x " + b + " x " + c)
	println("Result: " + x)
	println()
	return x
}

def division3(a:Int, b:Int, c:Int):Int ={
	var x = (a / b / c)
	println(a + " / " + b + " / " + c)
	println("Result: " + x)
	println
	return x
}

var x3 = addition3 (5,76, 3)
var y3 = multiplication3(3,5,1)
var z3 = division3 (80, 2, 5)

calculation3(subtraction3)