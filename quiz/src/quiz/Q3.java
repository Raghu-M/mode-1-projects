package quiz;

public class Q3 {
	public static void main(String[] args) {
		int i=1;
		int j=0;
		j=i++ + 1;
		System.out.println(i);
		System.out.println(j);
		i=1;
		j=++i + 1;
		System.out.println(i);
		System.out.println(j);
	}
}
