class info(){
	private var years = 0
	private var name = ""
	def days = years
	def days_= (years:Int) = {
		if (years < 150 && years >= 0){ 
			println(years)
		}
		else{
			println("Invalid age")
		}
	}
	def forename = name
	def forename_= (name:String) = {
		if (name == "Ebai"){
			println(name)
		}
		else{
			println("You ain't welcome")
		}
	}
}

var x = new info()
x.days = 64
x.forename = "Eba"