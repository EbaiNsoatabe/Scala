var x = 0
var y = 0
var words = ""
var letter = ""

def piglatin(a:String){
	while(x < a.length){
		letter = a.substring(x, x+1)
		if(letter != " "){
			x += 1
		}
		else{
			if(y == 0){
				print(a.substring(1, x) + a.substring(0, 1) + "ay ")
			}
			else{
				print(a.substring(y+2, x) + a.substring(y+1, y+2) + "ay ")
			}
		words = a.substring(0, x)
		y = words.length
		x += 1
		}
	}
}

var sentence = scala.io.StdIn.readLine() + " "
piglatin(sentence)