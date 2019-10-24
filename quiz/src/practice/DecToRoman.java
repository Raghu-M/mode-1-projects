package practice;

import java.util.HashMap;

public class DecToRoman {
	
	int[] base = new int[]{
		1000,900,500,400,100,90,50,40,10,9,5,4,1
	};
	  HashMap<Integer, String> map = new HashMap<Integer, String>();
	  void setup(){
		 map.put(1,"I");
		 map.put(4,"IV");
		 map.put(5,"V");
		 map.put(9,"IX");
		 map.put(10,"X");
		 map.put(40,"XL");
		 map.put(50,"L");
		 map.put(90,"XC");
		 map.put(100,"C");
		 map.put(400,"CD");
		 map.put(500,"D");
		 map.put(900,"CM");
		 map.put(1000,"M");
	 }
	 public String toroman(int num){
		 setup();
		 String res = new String();
		 for(int i : base){
			 while(num>=i){
				 res+=map.get(i);
				 num-=i;
			 }
		 }
		 return res;
	 }
	 public static void main(String[] args) {
		int n =45682;
		String Res = new DecToRoman().toroman(n);
		System.out.println(Res); 
	}

}
