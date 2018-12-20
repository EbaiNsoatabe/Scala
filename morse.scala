var sentence = scala.io.StdIn.readLine()
var letter = ""
var x = 0
while(x < sentence.length){
	letter = sentence.substring(x, x+1)
	letter match{
		case "A"|"a" => print(".- ")
		case "B"|"b" => print("-... ")
		case "C"|"c" => print("-.-. ")
		case "D"|"d" => print("-.. ")
		case "E"|"e" => print(". ")
		case "F"|"f" => print("..-. ")
		case "G"|"g" => print("--. ")
		case "H"|"h" => print(".... ")
		case "I"|"i" => print(".. ")
		case "J"|"j" => print(".--- ")
		case "K"|"k" => print("-.- ")
		case "L"|"l" => print(".-.. ")
		case "M"|"m" => print("-- ")
		case "N"|"n" => print("-. ")
		case "O"|"o" => print("--- ")
		case "P"|"p" => print(".--. ")
		case "Q"|"q" => print("--.- ")
		case "R"|"r" => print(".-. ")
		case "S"|"s" => print("... ")
		case "T"|"t" => print("- ")
		case "U"|"u" => print("..- ")
		case "V"|"v" => print("...- ")
		case "W"|"w" => print(".-- ")
		case "X"|"x" => print("-..- ")
		case "Y"|"y" => print("-.-- ")
		case "Z"|"z" => print("--.. ")
		case " " => print("   ")
	}
	x += 1
}