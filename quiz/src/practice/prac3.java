package practice;

class Employ {
	String name;
	public Employ(String name){
		this.name =name;
	}
	@Override
	public String toString() {
		return "Employ [name=" + name + "]";
	}	
}

class HrEmploy extends Employ{
	public HrEmploy(String name){
		super(name);
	}
}
	
 class JavaEmploy extends Employ{
	public JavaEmploy(String name){
		super(name);
	}		
}


public class prac3 {
	public static void main(String[] args) {
		Employ[] emp = new Employ[]{
				new HrEmploy("sagar"),
				new JavaEmploy("raghu"),
				new HrEmploy("kalla"),
				new HrEmploy("manju"),
				new HrEmploy("prem"),
				new JavaEmploy("kumara"),
				new HrEmploy("mauni"),
				new JavaEmploy("kowsi"),
				new HrEmploy("cahnadan"),
				new JavaEmploy("jerry")
				};
		for(Employ i : emp){
			if(i instanceof JavaEmploy){
			System.out.println(i);
			}
		}
	}

}
