package co.edu.uptc.activity.two.second;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity {

	private static Person readPerson(String path) {
		Person person = new Person();
		try (DataInputStream stream =new DataInputStream(new FileInputStream(path))){
			person.setId(stream.readLong());
			person.setFullName(stream.readUTF());
			person.setPhone(stream.readUTF());
			person.setSalary(stream.readDouble());
			person.setAge(stream.readInt());
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
		return person;
	}
	private static void writeNewPerson(String path, Person person) {
		try(DataOutputStream stream = new DataOutputStream(new FileOutputStream(path))){
			stream.writeUTF(person.getFullName());
			stream.writeDouble(person.getSalary());
			stream.writeInt(person.getAge());
			stream.writeUTF(person.getPhone());
			stream.writeLong(person.getAge());
		}catch (IOException e) {
			System.err.println(e.getStackTrace());
			// TODO: handle exception
		}
	}
	private static String revertFullName(String fullName, String useDecode) {
		StringBuilder builder = new StringBuilder();
		String [] names = fullName.split(useDecode);
		for (int i = names.length-1; i >= 0; i--) {
			builder.append(names[i]).append(" ");
		}
		return builder.toString();
	}
	private static long multiplyId(long id) {
		long result = id * 2;
		return result;
	}
	private static double splitSalary(double salary) {
		double result = salary / 2;
		return result;
	}
	private static int subtractAge(int age) {
		int result = age - 10 ;
		return result;
	}

	public static void main(String[] args){
		Person oldPerson = readPerson("resources/input/person.bin");
		oldPerson.setFullName(revertFullName(oldPerson.getFullName(), " "));
		oldPerson.setId(multiplyId(oldPerson.getId()));
		oldPerson.setSalary(splitSalary(oldPerson.getSalary()));
		oldPerson.setAge(subtractAge(oldPerson.getAge()));
		writeNewPerson("resources/out/new-person.ddr", oldPerson);
		System.out.println(oldPerson);
	}

}
