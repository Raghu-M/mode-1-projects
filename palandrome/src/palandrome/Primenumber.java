package palandrome;
import java.util.Scanner;
public class Primenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		int n=obj.nextInt();
		int flag=1; // prime
		int j=2;
		//System.out.println(n);
	for(int i=3;i<=n;i++)
	{
		//System.out.print(i+" ");
		while(j<=i/2)
		{
			if(i%j==0 ){
				flag=0;
				//break;
			}
		
			j++;	
		}j=2;
		if(flag==1){
			//System.out.print(i+" ");
			}
	}
}
}


