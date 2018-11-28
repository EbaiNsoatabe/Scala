var countries = List("UK", "Spain", "Italy", "Germany", "Sweden")

def findcapitals(a:String):String = {
	var city = ""
	if (a == "UK"){
		city = "London"
	}
	else if (a == "Spain"){
		city = "Madrid"
	}
	else if (a == "Italy"){
		city = "Rome"
	}
	else if (a == "Germany"){
		city = "Berlin"
	}
	else if (a == "Sweden"){
		city = "Stockholm"
	}
	else{
		city = "Country not found"
	}
	println(a)
	println(city)
	println()
	return city
}

var capital = countries.map(findcapitals)

