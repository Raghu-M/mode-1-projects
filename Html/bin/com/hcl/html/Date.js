function show(){
	var res = "";
	var obj = new Date();
	res += "today date is " + obj.getDate() +"</br>";
	res += "month is " + (obj.getMonth()+1) + "</br>";
	res += "year is " +obj.getFullYear( )+"</br>";
	res += "hour is " +obj.getHours( )+"</br>";
	res += "minutes is " +obj.getMinutes( )+"</br>";
	res += "seconds is " +obj.getSeconds( )+"</br>";
	document.getElementById("res").innerHTML = res;
}