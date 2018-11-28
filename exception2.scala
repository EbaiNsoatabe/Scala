class absence extends Exception{}

class payroll{
	def salarycalculations(salary:Int, absences:Int)={
		if(absences >= 6){
			var x = new absence()
			throw x
		}
		else{
			var calc = (salary - absences*100)
			var net = calc*0.85
			println("Net salary: " + net)
		}
	}
}

var ref = new payroll()

try{
	ref.salarycalculations(6422, 6)
}
catch{
	case x:absence => {
		println("Too many absences")
	}
}