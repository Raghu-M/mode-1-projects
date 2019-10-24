package practice;

public class StringMethods {
	
	public void test(String str){
		char[] c = str.toCharArray();
		System.out.println("the character at 5t position is..."+c[2]);
		int count=0;
		for(char i :c){
			count++;
		}
		System.out.println(count);
		
		for(int i=0;i<count;i++){
			if(c[i]>='a' && c[i]<='z'){
				int a=c[i]-('a'-'A');
				c[i]=(char)a;
			}
		}
		System.out.println(c);
		for(int i=0;i<count;i++){
			int a = c[i]+('a'-'A');
			c[i]=(char)a;
		}
		System.out.println(c);
	}

	
	public static void main(String[] args) {
		String str = "HelloSC";
		StringMethods ob = new StringMethods();
		ob.test(str);
	}

}
