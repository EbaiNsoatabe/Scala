class refer{
	var x = 150
	def message(a:Int)={
		var x = a
		if (x > 150){
			println("Marks Achieved: " + this.x)
		}
		else{
			println("Marks Achieved: " + x)
		}
	}
	def message2()={
		println("Marks Possible: " + x)
	}
}
var ref = new refer()
ref.message(259)
ref.message2()