package co.edu.uptc.activity.two.second;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import co.edu.uptc.activity.two.first.Person;

public class SecondActivity {
	private static Person readPerson(String path) {
		Person person= new Person(path, path, 0, 0, 0);
		File file = new File(path);
		
		try(DataInputStream stream =new DataInputStream(new FileInputStream(path))){
			person.setId(stream.readLong());
			person.setFullName(stream.readUTF());
			person.setPhoneNumber(stream.readUTF());
			person.setSalary(stream.readDouble());
			person.setAge(stream.readInt());
			
		}catch(IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
		return person;
	}

	public static void main(String[] args) {
		Person oldPerson= readPerson("src/resources/input/person.bin");
		System.out.println(oldPerson);
	}
	

}
