package student;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteStudent {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("c:/Files/hello.txt");
			ObjectOutputStream objout = new ObjectOutputStream(fout);
			Student s = new Student(15, "raghu", "bangalore", 5.7);
			objout.writeObject(s);
			objout.close();
			fout.close();
			System.out.println("*** student Record Stored ***");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
