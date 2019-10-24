i=0;
questions = [
             "1. What is Object Oriented Programming",
             "2. Who introduced Java",
             "3. How to declare Generics",
             "4. Why String.format() is used for ?"
             ]
options = [
           ["java","c","python","css"],
           ["raghu","prem","Nicolas Tesla","Arjun"],
           ["by Calling","Initializing","Declaring","None of these"],
           ["May be I know","I don't know","I know","Who knows"]
           ]
answers = [
           "java","Arjun",by Calling
           ]

function show(){
	document.getElementById("question").innerHTML = questions[i];
	for(var j=0;j<4;j++){
		document.getElementById("op"+(j+1)).innerHTML = options[i][j];
		onlineMcq.name.value = 
	}
}
function nextQuestion(){
	i+=1;
	if(i<4){
		show();
		if(i==3) onlineMcq.next.value = "Submit";
	} else alert("Exam over....");
}