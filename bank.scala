import java.sql.{Connection,DriverManager}

def programme()={
	try{
		Class.forName("com.mysql.cj.jdbc.Driver")
		var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "")
		val statement = connection.createStatement
		println("Enter 1 to create a new account")
		println("Enter 2 to deposit money into an existing account")
		println("Enter 3 to withdraw money from your account")
		var choice = scala.io.StdIn.readInt()
		println("")
		if (choice == 1){
			print("Name: ")
			val name = scala.io.StdIn.readLine()
			print("Location: ")
			val address = scala.io.StdIn.readLine()
			println("")
			print("Do you want to save this action? Y/N")
			println("")
			var save = scala.io.StdIn.readLine()
			println()
			if (save == "y" || save == "Y"){
				statement.executeUpdate("INSERT INTO personal values(null, '"+name+"', '"+address+"')")
				println("Account for " + name + " created.")
			}			
			else{
				println("We are sorry you decided against creating an account with us today")					
			}
		}
		if (choice == 2 || choice == 3){
			statement.executeQuery("SELECT * FROM personal")
			print("Enter your account number: ")
			var account = scala.io.StdIn.readInt()
			println()
			val details = statement.executeQuery("SELECT * FROM personal where AccNo = '"+account+"'")
			while(details.next){
				val id = details.getString("Name")
				val location = details.getString("Address")
				println("Hello, " + id + " from " + location + "!")
				println()
			}
			if (choice == 2){
				print("How much would you like to deposit? ")
				var amount = scala.io.StdIn.readInt()
				print("You have deposited £" + amount)
				statement.executeUpdate("INSERT INTO deposits values('"+account+"', '"+amount+"', SYSDATE())")
			}
			else{
				print("How much would you like to withdraw? ")
				var amount = scala.io.StdIn.readInt()
				statement.executeUpdate("INSERT INTO withdrawals values('"+account+"', '"+amount+"', SYSDATE())")
				print("You have withdrawn £" + amount)			
			}
		}
		println()
	}
	catch{
		case e:Exception => println(e)
	}
}

def more()={
	println()
	print("Do you need anything else? Y/N ")
	println()
	var repeat = scala.io.StdIn.readLine()
	if (repeat == "n" || repeat == "N"){
		println("Goodbye")
		sys.exit(0)
	}
	if  (repeat == "y" || repeat == "Y"){
		println()
		programme()
	}
}

programme()
while(1 < 2){
	more()
}

//connection.close