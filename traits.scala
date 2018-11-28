abstract class bank{
	def deposit()
	def withdraw()
}

trait lending{
	def loan()
}

trait location{
	def address()
}

class HSBC extends bank with lending{
	override def deposit(){
		println("HSBCdeposited")
	}
	override def withdraw(){
		println("HSBC withdraw")
	}
	override def loan(){
		println("HSBC loans")
	}
}

var ref = new HSBC()
ref.withdraw()

class rbs extends bank with lending with location{
	override def deposit(){
		println("RBSdeposited")
	}
	override def withdraw(){
		println("RBSwithdraw")
	}
	override def loan(){
		println("RBSloans")
	}
	override def address(){
		println("RBSEdinburgh")
	}
}

var x = new rbs()
x.address
