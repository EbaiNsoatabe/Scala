def conversion(a: Int):String={
	var num = a
	var binary = ""
	while (num > 1){
		binary = num%2 + binary
		num = num/2
	}
	if (num <= 1){
		binary = num + binary
	}
	return binary
}

def exponential(a: Int, b: Int):Int ={
	var answer = Math.pow(a, b).toInt
	return answer
}

var x = 34
println(x + " converted into binary is " + conversion(x))


var value = conversion(x)
var z = value.length - 1
var returns = 0
var letters = 0

while(letters <= z){
	if ((value.substring(letters, letters + 1)) == "1"){
		returns += exponential(2, (z - letters))
	}
	letters += 1
}
println(value + " reverted into decimal is " + returns)	