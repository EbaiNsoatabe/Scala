class myexc extends Exception{}

var one = 43
var two = 44

try{
		if(two>one){
			var ref = new myexc()
			throw ref
		}
}
catch{
	case x:myexc => {
		println("Exception")
	}
}