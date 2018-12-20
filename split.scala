print("Enter your number: ")
var number = scala.io.StdIn.readInt()

def units(a:Int){
	println(a)
}
def tens(a:Int){
	var x = a/10
	if(number >= 10){
		println(x)
	}
	var y = (a - x*10)
	units(y)
}

def hundreds(a:Int){
	var x = a/100
	if(number >= 100){
		println(x)
	}
	var y = a - (x*100)
	tens(y)
}

def thousands(a:Int){
	var x = a/1000
	if(number >= 1000){
		println(x)
	}
	var y = a - (x*1000)
	hundreds(y)
}

def tenthou(a:Int){
	var x = a/10000
	if(number >= 10000){
		println(x)
	}
	var y = a - (x*10000)
	thousands(y)
}

def hunthou(a:Int){
	var x = a/100000
	if(number >= 100000){
		println(x)
	}
	var y = a - (x*100000)
	tenthou(y)
}

def millions(a:Int){
	var x = a/1000000
	if(number >= 100000){
		println(x)
	}
	var y = a - (x*1000000)
	hunthou(y)
}

if(number >= 10000000 && number < 100000000){
	var digit = number/10000000
	units(digit)
	millions(number - (digit*10000000))
}
else if(number >= 100000000 && number < 1000000000){
	var digit = number/10000000
	tens(digit)
	millions(number - (digit*10000000))
}
else{
	println("Number too large")
}