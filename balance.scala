import java.sql.{Connection,DriverManager}

var bank = List(102, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122)

Class.forName("com.mysql.cj.jdbc.Driver")
var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "")
val statement = connection.createStatement

def balance(a:Int):Boolean={
	var account = a
	var funds = 0
	var deposited = statement.executeQuery("SELECT SUM(Amount) FROM deposits where AccNo = '"+account+"'")
	while(deposited.next){
		var deposit = deposited.getInt("SUM(Amount)")
		funds = funds + deposit
	}
	val withdrawn = statement.executeQuery("SELECT SUM(Amount) FROM withdrawals where AccNo = '"+account+"'")
	while(withdrawn.next){
		var withdraw = withdrawn.getInt("SUM(Amount)")
		funds = funds - withdraw
	}
	if (funds <= 0){
		val details = statement.executeQuery("SELECT * FROM personal where AccNo = '"+account+"'")
		while(details.next){
		val called = details.getString("Name")
		println(called)
		}
		println(a)
		println("£" + funds)
		println()
		return true
	}
	else{
		return false
	}
}

var check = bank.filter(balance)
