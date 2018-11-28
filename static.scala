object bank{
	var euro = 0.96
}

class bank{
	def amount(x:Int)={
		println("Amount: " + (x*bank.euro))
	}
	def seteuro(x:Double)={
		bank.euro = x
	}
}

var santander = new bank()
var rbs = new bank()
var barclays = new bank()

santander.amount(100)
barclays.seteuro(0.95)
rbs.amount(200)