def grades(a: Int): String={
	var letter = ""
	if(a >= 0 && a < 70){
		letter = "C"
	}
	else if(a >= 70 && a < 80){
		letter = "B"
	}
	else if(a >= 80 && a < 90){
		letter = "A"
	}
	else{
		letter = "A+"
	}
	return letter
}

class exams{
	private var physics = 0
	private var chemistry = 0
	private var mathematics = 0
	private var total:Int = 0
	private var percent = 0
	private var problem = 0
	private var fail = 0
	def phy(a:Int)={
		if (a >= 0 && a <= 150){
			physics = a
			if (a < 90){
				println("You have failed physics")
				println()
				fail += 1
			}
			else{
				println("Physics Mark: " + physics)
				println("Physics Grade: " + grades((physics*100)/150))
				println()
			}
		}
		else{
			println("Invalid phyics mark")
			problem += 1 
		}
	}
	def chem(a:Int)={
		if (a >= 0 && a <= 150){
			chemistry = a
			if (a < 90){
				println("You have failed chemistry")
				println()
				fail += 1
			}
			else{
				println("Chemistry Mark: " + chemistry)
				println("Chemistry Grade: " + grades((chemistry*100)/150))
				println()
			}
		}
		else{
			println("Invalid chemistry mark")
			problem += 1
		}
	}
	def maths(a:Int)={
		if (a >= 0 && a <= 150){
			mathematics = a
			if (a < 90){
				println("You have failed maths")
				println()
				fail += 1
			}
			else{
				println("Maths Mark: " + physics)
				println("Maths Grade: " + grades((mathematics*100)/150))
				println()
			}
		}
		else{
			println("Invalid maths mark")
			problem += 1
		}
	}
	private def calculation()={
		total = physics + chemistry + mathematics
		percent = (total*100)/450
	}
	def results()={
		calculation()
		if (problem >= 1){
			println("Error with entry")
		}
		else{
			if (fail == 0){
				println("Total marks: " + total)
				println("Percentage: " + percent)
				println("Overall Grade: " + grades(percent))
			}
			fail match{
				case 0 => print("")
				case 1 => println("Resit the exam")
				case 2 => println("Retake the year")
				case _ => println("Go home")
			}
		}
	}
}

var ebai = new exams()
ebai.chem(92)
ebai.phy(88)
ebai.maths(22)
ebai.results