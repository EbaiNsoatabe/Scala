import java.sql.{Connection,DriverManager}

class bankingsystem{
	Class.forName("com.mysql.cj.jdbc.Driver")
	var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking", "root", "")
	val statement = connection.createStatement
	
	def calculations(a:Int):Int={
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
	return funds
	}
	
	def programme()={
		try{
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
					val personal = statement.executeQuery("SELECT MAX(AccNo) from personal")
					while(personal.next){
						val identify = personal.getString("MAX(AccNo)")
						println("Your new account number is " + identify)
					}
				}			
				else{
					println("We are sorry you decided against creating an account with us today")				
				}
				
			}
			if (choice == 2 || choice == 3){
				print("Enter your account number: ")
				var account = scala.io.StdIn.readInt()
				var cash = calculations(account)
				val maximum = statement.executeQuery("SELECT MAX(AccNo) FROM personal")
				while(maximum.next){
					var possible = maximum.getInt("MAX(AccNo)")
					if (account > 100 && account <= possible){
						println()
					}
					else{
						println("Invalid account number. Goodbye")
						println()
						sys.exit(0)
					}
				}
				val details = statement.executeQuery("SELECT * FROM personal where AccNo = '"+account+"'")
				while(details.next){
					val called = details.getString("Name")
					val location = details.getString("Address")
					println("Hello, " + called + " from " + location + "!")
					println()
				}
				if (choice == 2){
					print("How much would you like to deposit? ")
					var amount = scala.io.StdIn.readInt()
					println("You have deposited £" + amount)
					statement.executeUpdate("INSERT INTO deposits values('"+account+"', '"+amount+"', SYSDATE())")
					println("Your new balance is £" + (cash+amount))
				}
				else{
					println("Your current balance is £" + calculations(account))
					print("How much would you like to withdraw? ")
					var amount = scala.io.StdIn.readInt()
					
					if (cash >= amount){
						println()
						println("Confirm you would like to withdraw £" + amount + " by pressing the y key")
						print("Abort the deposit by pressing any other key")
						var confirm = scala.io.StdIn.readLine()
						if(confirm == "y" || confirm == "Y"){
							println()
							println("You have withdrawn £" + amount)
							println("Your new balance is £" + (cash-amount))
						}
						else{
							print("Deposit cancelled. You will now be logged out, goodbye.")
							sys.exit(0)
						}
					}
					else{
						println("Sorry, insufficient funds for withdrawal. You will now be logged out.")
						sys.exit(0)
					}
				statement.executeUpdate("INSERT INTO withdrawals values('"+account+"', '"+amount+"', SYSDATE())")
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
		var repeat = scala.io.StdIn.readLine()
		if (repeat == "n" || repeat == "N"){
			println()
			println("Goodbye")
			sys.exit(0)
		}
		if  (repeat == "y" || repeat == "Y"){
			println()
			programme()
		}
	}
}

var ref = new bankingsystem()
ref.programme()

while(1 < 2){
	ref.more()
}

//connection.close