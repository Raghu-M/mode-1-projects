package quiz;
enum Test{
	A, B, X, Y;
		private Test(){
			System.out.println("hi");
		}
}
public class ENUM1 {
	public static void main(String[] args) {
		for(Test i :Test.values()){
		}
		
	}
}
