package student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class StudentRead {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("c:/Files/hello.txt");
			ObjectInputStream objin = new ObjectInputStream(fin);
			Student s = (Student)objin.readObject();
			objin.close();
			fin.close();
			System.out.println(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
