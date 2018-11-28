class absence extends Exception{}
class errors extends Exception{}
class limit extends Exception{}
class minimum extends Exception{}

class payroll{
	var net = 0
	def salarycalculations(salary:Int, absences:Int):Int={
		if(absences >= 24){
			var y = new errors()
			throw y
		}	
		else if(absences >= 6){
			var x = new absence()
			throw x
		}
		else if(salary >= 50000){
			var z = new limit()
			throw z
		}
		else if(salary < 1000){
			var x1 = new minimum()
			throw  x1
		}
		else{
			net = (salary*85)/100
			println("Net salary: " + net)
		}
		return net
	}
}

var ref = new payroll()

try{
	ref.salarycalculations(64220, 2)
}
catch{
	case x:absence => {
		println("Too many absences")
	}
	case y:errors => {
		println("Not enough working days in month")
	}
	case z:limit => {
		println("Monthly wage too high")
	}
	case l:minimum => {
		println("Monthly wage too low")
	}
}