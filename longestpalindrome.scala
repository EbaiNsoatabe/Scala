print("Enter a word: ")
var word = scala.io.StdIn.readLine()
var b = 0
import scala.collection.mutable.ListBuffer
var list = ListBuffer[String]()
var n = 0
var loop = 0

class palindrome{	
	def oddpalindrome(a:String){
		var length = a.length
		var first = a.substring(0, length/2)
		var second = a.substring((length/2) + 1, a.length)
		if(first == second.reverse){
			list += a
			b = 0
		}
		else{
			b += 1
		}
	}

	def evenpalindrome(a:String){
		var length = a.length
		var first = a.substring(0, length/2)
		var second = a.substring((length/2), a.length)
		if(first == second.reverse){
			list += a
			b = 0
		}
		else{
			b += 1
		}
	}
}

var ref = new palindrome()

def check(c:String){
	if(c.length % 2 != 0){
		ref.oddpalindrome(c)
	}
	else{
		ref.evenpalindrome(c)
	}
}

check(word.substring(0, word.length))

for(i <- 1 until word.length){
	check(word.substring(0, word.length-i))
	check(word.substring(i, word.length))
	if(i >= 2){
		for(a <- 1 until (word.length - i)){
			check(word.substring(i, word.length-(a-1)))
		}
	}
}

for(i <- 0 until list.length){
	if(list(i).length > n){
		n = list(i).length
	}
}

for(i <- 0 until list.length){
	if(list(i).length == n){
		print(list(i) + " is the longest palindrome")
	}
}