function show(){
	var res="";
	var a = [5,
				"raghu",
				function(){
					return "welcome";
				},
				{
					'city' : 'bangalore',
					'State' : 'karnataka'}
				];
	res += "first element = "+a[0]+"</br>"
	res += "first element = "+a[1]+"</br>"
	res += "first element = "+a[2]()+"</br>"
	res += "first element = "+a[3].city+"</br>"
	res += "first element = "+a[3].State+"</br>"
	document.getElementById("res").innerHTML = res;
}