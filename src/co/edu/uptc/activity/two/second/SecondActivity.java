package co.edu.uptc.activity.two.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class SecondActivity {
	
	public static Person modifyPerson(Person person) {
		
		person.setAge(person.getAge()-10);
		person.setId(person.getId()*2);
		String [] fullNames = person.getName().split(" ");
		person.setName(fullNames[3]+" " +fullNames[2]+" "+fullNames[1]+" "+fullNames[0]);
		person.setSalary(person.getSalary()/2);
			
			return person;
	}
	public static void writePerson(Person person) throws IOException {
		
		DataOutputStream  output = new DataOutputStream(new FileOutputStream("src\\resources\\output\\new-person.ddr"));
		
		output.writeUTF(person.getName());
		output.writeDouble(person.getSalary());
		output.writeInt(person.getAge());
		output.writeUTF(person.getPhone());
		output.writeLong(person.getId());
		output.close();
	}
	public static void main(String[] args) throws IOException {
		DataInputStream fi= new DataInputStream(new FileInputStream("src\\resources\\input\\person.bin"));
		Person person = new Person(fi.readLong(),fi.readUTF(),fi.readUTF(),fi.readDouble(),fi.readInt());
		SecondActivity.writePerson(SecondActivity.modifyPerson(person));
	
	}
}