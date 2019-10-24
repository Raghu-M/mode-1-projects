package quiz;

class C1{
	int a,b;
	public C1(int c, int d){
		a=c;
		b=d;
		
	}
	@Override
	public final String toString() {
		return "C1 [a=" + a + ", b=" + b + "]";
	}
}
class C2 extends C1{
	public C2(int a,int b){
		super(a,b);
	}
}
public class Inh5 {
	 public static void main(String[] args) {
		C2 obj = new C2(12,5);
		System.out.println(obj);
	}
}
