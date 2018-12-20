println("Enter a sentence: ")
var sentence = scala.io.StdIn.readLine()
sentence = sentence + " "
var str = " "
var x = 0
var y = 0

println("**************")

while(x < sentence.length){
	if(sentence.substring(x, x+1) != str){
		x += 1
	}
	else{
		var words = sentence.substring(y, x)
		if(y == 0){
			var m = words.length
			m match{
				case 1 => println("* " + words + "          *")
				case 2 => println("* " + words + "         *")
				case 3 => println("* " + words + "        *")
				case 4 => println("* " + words + "       *")
				case 5 => println("* " + words + "      *")
				case 6 => println("* " + words + "     *")
				case 7 => println("* " + words + "    *")
				case 8 => println("* " + words + "   *")
				case 9 => println("* " + words + "  *")
				case 10 => println("* " + words + "*")
				case _ => println("word is too long")
			}
		}
		else{
			var l = words.length
			l match{
				case 1 => println("*" + words + "           *")
				case 2 => println("*" + words + "          *")
				case 3 => println("*" + words + "         *")
				case 4 => println("*" + words + "        *")
				case 5 => println("*" + words + "       *")
				case 6 => println("*" + words + "      *")
				case 7 => println("*" + words + "     *")
				case 8 => println("*" + words + "    *")
				case 9 => println("*" + words + "   *")
				case 10 => println("*" + words + " *")
				case 11 => println("*" + words + "*")
				case _ => println("word is too long")
			}
		}
		x += 1
		y += words.length
	}
}

println("**************")
