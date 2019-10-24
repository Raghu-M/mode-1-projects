<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

function show() {
	//alert("Hi");
	document.getElementById("h").disabled = false;
}

function myfunction(){
	var checkboxes = document.getElementsByName("chk");
	var y = document.getElementById("but");
	var selected = [];
	var count=0;
	for (var i=0; i<checkboxes.length; i++) {
	    if (checkboxes[i].checked) {
	       count++;
	    }
	}
	if(count==0){
		y.disabled = true;
	} else {
		y.disabled = false;
	}
}

function myfunction1(){
	var x = document.getElementById('myDiv1');
	var y = document.getElementById('myDiv');
	if(x.style.visibility === 'hidden'){
		x.style.visibility = 'visible';
		y.style.visibility = 'hidden';
	} else {	
		x.style.visibility = 'hidden';
	}
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form name="c" id="C">
			<input type="checkbox" onchange="myfunction()" name="chk" /> <input
				type="checkbox" onchange="myfunction()" name="chk" /> <input
				type="checkbox" onchange="myfunction()" name="chk" /> <input
				type="button" id="but" value="hello hi" disabled />
		</form>
	</center>

</body>
</html>