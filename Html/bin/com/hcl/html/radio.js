function show(){
	//var res = "";
	var radio = document.getElementsByName("gender");
	for(var i =0;i<radio.length;i++){
		if(radio[i].checked){
			res=radio[i].value;
		}
	}
	document.getElementById("res").innerHTML = res;
}