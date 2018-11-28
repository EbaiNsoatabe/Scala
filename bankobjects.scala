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
			val details = statement.executeQuery("SELECT * FROM personal where AccNo = '"+account+"'")
			while(details.next){
				val id = details.getString("Name")
				print("How much would you like to withdraw today, " + id + "? ")
			}
			var withdraw = scala.io.StdIn.readInt()
			println()
			statement.executeUpdate("INSERT INTO withdrawals VALUES('"+account+"', '"+withdraw+"', SYSDATE())")
			println("You have withdrawn £" + withdraw)
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