package practice;

public class Prac4 {
	public static void main(String[] args) {
		Object[] arr = new Object[]{
				12,"welcome",12.5,"hcl",
				'A',"java",true,11,11.6,"Bangalore"		
				};
		System.out.println("\nIntegers");
		for(Object i : arr){
			if(i instanceof Integer){
				System.out.print(i+"   ");
			}
		}
		System.out.println("\n\nDouble");
		for(Object i : arr){
			if(i instanceof Double){
				System.out.println(i);
			}
		}
		System.out.println("\nString");
		for(Object i : arr){
			if(i instanceof String){
				System.out.println(i);
			}
		}
		System.out.println("\nChar");
		for(Object i : arr){
			if(i instanceof Character){
				System.out.println(i);
			}
		}
		System.out.println("\nBoolean");
		for(Object i : arr){
			if(i instanceof Boolean){
				System.out.println(i);
			}
		}
	}

}
