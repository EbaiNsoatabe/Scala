def exponential(a: Int, b: Int):Int ={
	var answer = Math.pow(a, b).toInt
	return answer
}

class tobinary{
	var x = 0
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
}

class todecimal extends tobinary{
	def reversion(bin:String):Int={
		var value = bin
		var z = value.length - 1
		var returns = 0
		var letters = 0
		while(letters <= z){
			if ((value.substring(letters, letters + 1)) == "1"){
				returns += exponential(2, (z - letters))
			}
			letters += 1
		}
		return returns
	}
}

var binref = new tobinary()
var decref = new todecimal()

print("Enter your number: ")
binref.x = scala.io.StdIn.readInt()

var binum = binref.x
var decinum = binref.conversion(binum) 
var revert = decref.reversion (decinum)

println(binum + " converted into binary is " + decinum)
println(decinum + " reverted into decimals is " + revert)