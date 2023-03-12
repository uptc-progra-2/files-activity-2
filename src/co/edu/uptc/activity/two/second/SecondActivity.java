package co.edu.uptc.activity.two.second;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity {
	private static Person readPerson(String path){
		Person person=new Person();
		File file= new File (path);
		try (DataInputStream stream =new DataInputStream(new FileInputStream(path))){
			person.setId(stream.readLong());
			person.setFullName(stream.readUTF());
			person.setPhoneNumber(stream.readUTF());
			person.setSalary(stream.readDouble());
			person.setAge(stream.readInt());
//			byte[] bytes=new byte[(int)file.length()]; SAber la longitud bytes
//			byte[] bytes=new byte[stream.available()];
//			stream.read(bytes);
//			stream.readFully(bytes);
			
		}catch(IOException e ) {
			System.err.println(e.getStackTrace());
		}
		return person;
		
	}
	
	private static void writeNewPerson(String path, Person person) {
		try(DataOutputStream stream =new DataOutputStream(new FileOutputStream(path))) {
			stream.writeUTF(person.getFullName());
			stream.writeDouble(person.getSalary());
			stream.writeInt(person.getAge());
			stream.writeUTF(person.getPhoneNumber());
			stream.writeLong(person.getId());
			stream.close();
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}
	private static String revertFullNAme(String fullName, String useDecode) {
		StringBuilder builder =new StringBuilder();
		String[] names= fullName.split(useDecode);
		
		for(int i=names.length-1; i>=0; i--) {
			builder.append(names[i]).append(" ");
		}
		return builder.toString();
	}


	public static void main(String[] args) {
		Person oldPerson =readPerson("src/resources/input/person.bin");
		System.out.println(oldPerson);
//		Person newPerson= new Person();//No hay transmutación de la información
		oldPerson.setFullName(revertFullNAme(oldPerson.getFullName(), " "));
		oldPerson.setAge(oldPerson.getAge()-10);
		oldPerson.setId(oldPerson.getId()*2);
		oldPerson.setSalary(oldPerson.getSalary()/2);
		writeNewPerson("src/resources/output/new-person.ddr", oldPerson);
		System.out.println(oldPerson);
	}

}
