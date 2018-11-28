import java.sql.{Connection,DriverManager}

println("Enter 1 to create a new account")
println("Enter 2 to deposit money into an existing account")	
println("Enter 3 to withdraw money from your account")
var choice = scala.io.StdIn.readInt()
println("")

class database {
	Class.forName("com.mysql.cj.jdbc.Driver")
	var connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "")
	val statement = connection.createStatement
	
	def create()={
		try{
			print("Name: ")
			var name = scala.io.StdIn.readLine()
			println()
			print("Location: ")
			var location = scala.io.StdIn.readLine()
			println()
			print("ENTER y to confirm your account or any other key to abort")
			var confirm = scala.io.StdIn.readLine()
			if(confirm == "y" || confirm == "Y"){
				statement.executeUpdate("INSERT INTO personal values(null, '"+name+"', '"+location+"')")
				println("Account for " + name + " created.")
			}
			else{
				println("We're sorry that you chose not to create an account with us today")
			}
		}
		catch{
			case x:Exception => println(x)
		}
	}
	
	def depositing()={
		try{
			print("Please Enter your account number: ")
			var account = scala.io.StdIn.readInt()
			println()
			val details = statement.executeQuery("SELECT * FROM personal where AccNo = '"+account+"'")
			while(details.next){
				val id = details.getString("Name")
				val location = details.getString("Address")
				println("Hello, " + id + " from " + location + "!")
			}
			print("How much would you like to deposit today? ")
			var deposit = scala.io.StdIn.readInt()
			println()
			statement.executeUpdate("INSERT INTO deposits VALUES('"+account+"', '"+deposit+"', SYSDATE())")
			println("You have deposited £" + deposit)
		}
		catch{
			case x:Exception => println(x)
		}
	}
	
	def withdrawal()={
		try{
			print("Please Enter your account number: ")
			var account = scala.io.StdIn.readInt()
			println()
			print("How much would you like to withdraw? ")
			var amount = scala.io.StdIn.readInt()
			val balance = statement.executeQuery("SELECT SUM(Amount) FROM deposits where AccNo = '"+account+"'")
			val taken = statement.executeQuery("SELECT SUM(Amount) FROM withdrawals where AccNo = '"+account+"'")
			while(balance.next){
				val cash = balance.getInt("SUM(Amount)")
				val gone = taken.getInt("SUM(Amount)")
				println("Your current balance is £" + cash)
				if (cash >= (amount+gone)){
					println()
					println("Confirm you would like to withdraw £" + amount + " by pressing the y key")
					println("Abort the deposit by pressing any other key")
					var confirm = scala.io.StdIn.readLine()
					if(confirm == "y" || confirm == "Y"){
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
			}
			statement.executeUpdate("INSERT INTO withdrawals values('"+account+"', '"+amount+"', SYSDATE())")
		}
		catch{
			case x:Exception => println(x)
		}
	}
}

var banking = new database()

def menu()={
	if(choice == 1){
		banking.create()
	}
	else if(choice == 2){
		banking.depositing()
	}
	else if(choice == 3){
		banking.withdrawal()
	}
}

menu()

if(choice != 1 && choice != 2 && choice != 3){
	println("Invald response")
	menu()
}