class invalid extends Exception{}
class negative extends Exception{}

class exams(phy:Int, chem:Int, maths:Int){
	def results()={
		if(phy > 150|| chem > 150|| maths > 150){
			var x = new invalid()
			throw x
		}
		if(phy < 0 || chem < 0 || maths < 0){
			var y = new negative()
			throw y
		}
		println("Your exam marks:")
		println("Physics: " + phy)
		println("Chemistry: " + chem)
		println("Maths: " + maths)
		println("Total: " + (maths+chem+phy))
		println("Percentage: " + ((maths+chem+phy)*100/450))
	}
}

var ref = new exams(19, -103, 143)
try{
	ref.results()
}
catch{
	case x:invalid=>{
		println("Sorry, invalid marks entered")
	}
	case y:negative=>{
		println("Negative marks not allowed")
	}
}