class boom{
	println("Hello")
	def this(a:Int, b:Int)={
		this()
		println("Second constructor")
	}
	def this(a:Int, b:Int, c:Int)={
		this()
		println("Third constructor")
	}
}

var ref = new boom(6,7)