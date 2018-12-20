var word1 = scala.io.StdIn.readLine()
var word = word1
var word2 = scala.io.StdIn.readLine()
if(word1.length != word2.length){
	println(word + " and " + word2 + " are not anagrams.")
	sys.exit()
}
var count = 0
var i = 0
var a = 0
var x = 0

while(i < word1.length){
	while(a < word2.length){	
		if(word1.substring(i, i+1) == word2.substring(a, a+1)){
			while(x < word2.length){
				word1 = word1.substring(0, i) + word1.substring(i+1, word1.length)
				count += 1
				x += 1
			}
		}
		a += 1
	}
	i += 1
}

if(word2.length == count){
	println(word + " and " + word2 + " are anagrams!")
}
else{
	println(word + " and " + word2 + " are not anagrams.")
}