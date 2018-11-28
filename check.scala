def grades(a: Int): Str={
	var letter = ""
	if(a >= 0 && a < 70){
		letter += "Grade: C"
	}
	else if(a >= 70 && a < 80){
		letter += "Grade: B"
	}
	else if(a >= 80 && a < 90){
		letter += "Grade: A"
	}
	else{
		letter += "Grade: A+"
	}
	return letter
}
