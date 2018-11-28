def units(num: Int): String={
	var digits=""
	num match{
		case 1 => digits = "One "
		case 2 => digits = "Two "
		case 3 => digits = "Three "
		case 4 => digits = "Four "
		case 5 => digits = "Five "	
		case 6 => digits = "Six "
		case 7 => digits = "Seven "
		case 8 => digits = "Eight "
		case 9 => digits = "Nine "
		case 10 => digits = "Ten "
		case 11 => digits = "Eleven "
		case 12 => digits = "Twelve "
		case 13 => digits = "Thirteen "
		case 14 => digits = "Fourteen "
		case 15 => digits = "Fifteen "	
		case 16 => digits = "Sixteen "
		case 17 => digits = "Seventeen "
		case 18 => digits = "Eighteen "
		case 19 => digits = "Nineteen "
	}
	return digits
}

def tens(x: Int):String={
	var value = ""
		x match{
			case 2 => value = "Twenty "
			case 3 => value = "Thirty "
			case 4 => value = "Forty "
			case 5 => value = "Fifty "
			case 6 => value = "Sixty "
			case 7 => value = "Seventy "
			case 8 => value = "Eighty "
			case 9 => value = "Ninety "
		}
	return value
}

print("Enter your number (+-999999): ")
var x = scala.io.StdIn.readInt()

if((x >= 1000000) || (x <= -1000000)){
	println("Error: number not in permitted range")
} 

if (x == 0){
	println("Zero")
}
	
if (x < 0){
	print("Negative ")
	x = x*(-1)
}

if((x >= 100000) && (x < 1000000)){
	print(units(x/100000) + "Hundred ")
	if(x - ((x/100000)*100000) < 1000){
		print("Thousand ")
	}
	print("and ")
	x = x - ((x/100000)*100000)
}

if((x >= 20000) && (x < 100000)){
	print(tens(x/10000))
	if ((x - (x/10000)*10000) < 1000){
		print("Thousand ")
	}
	x = x - ((x/10000)*10000)
}

if((x >= 1000) && (x < 10000)){
	print(units(x/1000) + "Thousand ")
	x = x - ((x/1000)*1000)
	if (x < 100){
		print ("and ")
	}
}

if((x >= 100) && (x < 1000)){
	print(units(x/100) + "Hundred and ")
	x = x - ((x/100)*100)
}

if((x >= 20) && (x < 100)){
	print(tens(x/10))
	x = x - ((x/10)*10)
}

if((x >= 1) && (x < 20)){
	println(units(x))
}