print("Enter a word: ")
var word = scala.io.StdIn.readLine()

class palindrome{	
	def oddpalindrome(a:String){
		var length = a.length
		var first = a.substring(0, length/2)
		var second = a.substring((length/2) + 1, a.length)
		if(first == second.reverse){
		println(a + " is a palindrome")
		}
		else{
			println(a + " is not a palindrome")
		}
	}

	def evenpalindrome(a:String){
		var length = a.length
		var first = a.substring(0, length/2)
		var second = a.substring((length/2), a.length)
		if(first == second.reverse){
			println(a + " is a palindrome")
		}
		else{
			println(a + " is not a palindrome")
		}
	}
}

var ref = new palindrome()

if(word.length % 2 != 0){
	ref.oddpalindrome(word)
}
else{
	ref.evenpalindrome(word)
}