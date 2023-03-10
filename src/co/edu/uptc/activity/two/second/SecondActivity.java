package co.edu.uptc.activity.two.second;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src//resources//input//person.bin");
			DataInputStream dis = new DataInputStream(fis);
			
			long id = dis.readLong();
			String name = dis.readUTF();
			String telephone = dis.readUTF();
			double salary = dis.readDouble();
			int age = dis.readInt();
			
			Person person = new Person(name, salary, age, telephone, id);
			
			String[] separateName = name.split(" ");
			String newName = "";
			
			for (int i = separateName.length - 1; i >= 0; i--) {
				newName += separateName[i] + " ";
			}
			
			person.setName(newName);
			
			double newSalary = salary / 2;
			person.setSalary(newSalary);
			
			int newAge = age - 10;
			person.setAge(newAge);
			
			long newId = id * 2;
			person.setId(newId);
		
			FileOutputStream fos = new FileOutputStream("src//resources//output//new-person.ddr");
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeUTF(newName);
			dos.writeDouble(newSalary);
			dos.writeInt(newAge);
			dos.writeUTF(telephone);
			dos.writeLong(newId);
			
			dis.close();
			dos.close();
			
		} catch (IOException o) {
			o.printStackTrace();
		}
	}

}
