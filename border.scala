var sentence = scala.io.StdIn.readLine()
sentence = sentence + " "
var str = " "
var x = 0
var y = 0

println("*********")

while(x < sentence.length){
	if(sentence.substring(x, x+1) != str){
		x += 1
	}
	else{
		var words = sentence.substring(y, x)
		if(y == 0){
			println("* " + words + " *")
		}
		else{
			if(words.length == 6){ 
				println("*" + words + " *")
			}
			else if(words.length == 5){
				println("*" + words + "  *")
			}
			else if(words.length == 4){
				println("*" + words + "   *")
			}
			else if(words.length == 3){
				println("*" + words + "    *")
			}
			else if(words.length == 2){
				println("*" + words + "     *")
			}
			else if(words.length == 1){
				println("*" + words + "      *")
			}
		}
		x += 1
		y += words.length
	}
}

println("*********")