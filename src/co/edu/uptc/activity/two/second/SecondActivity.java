package co.edu.uptc.activity.two.second;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity {

	private static Person readPerson(String path) {
		Person person = new Person();
		try (DataInputStream stream = new DataInputStream(new FileInputStream(path))) {
			person.setId(stream.readLong());
			person.setFullName(stream.readUTF());
			person.setPhoneNumber(stream.readUTF());
			person.setSalary(stream.readDouble());
			person.setAge(stream.readInt());
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
		return person;
	}

	private static Person readActualPerson(String path) {
		Person actualPerson = new Person();
		try (DataInputStream stream = new DataInputStream(new FileInputStream(path))) {
			actualPerson.setFullName(stream.readUTF());
			actualPerson.setSalary(stream.readDouble());
			actualPerson.setAge(stream.readInt());
			actualPerson.setPhoneNumber(stream.readUTF());
			actualPerson.setId(stream.readLong());
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
		return actualPerson;
	}

	private static void writeNewPerson(String path, Person person) {
		try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(path))) {
			stream.writeUTF(revertFullName(person.getFullName(), " "));
			stream.writeDouble(actualSalary(person.getSalary()));
			stream.writeInt(actualAge(person.getAge()));
			stream.writeUTF(person.getPhoneNumber());
			stream.writeLong(actualId(person.getId()));
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	private static int actualAge(int age) {
		System.out.println(age - 10);
		return age - 10;
	}

	private static long actualId(long id) {
		System.out.println(id * 2);
		return id * 2;
	}

	private static String revertFullName(String fullName, String useDecode) {
		StringBuilder builder = new StringBuilder();
		String[] names = fullName.split(useDecode);
		for (int i = names.length - 1; i >= 0; i--) {
			builder.append(names[i]).append(" ");
		}
		System.out.println(builder.toString());
		return builder.toString();
	}

	private static double actualSalary(double salary) {
		System.out.println(salary / 2);
		return salary / 2;
	}

	public static void main(String[] args) {
		Person oldPerson = readPerson("src/resources/input/person.bin");
		writeNewPerson("src/resources/output/new-person.ddr", oldPerson);
		System.out.println(oldPerson);
		Person actualPerson = readActualPerson("src/resources/output/new-person.ddr");
		System.out.println(actualPerson);
	}
}
