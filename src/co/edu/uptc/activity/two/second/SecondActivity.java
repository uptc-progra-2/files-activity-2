package co.edu.uptc.activity.two.second;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SecondActivity {

	//metodo para lectura
	private static Person readPerson(String path){
		Person person = new Person();
		File file = new File(path);
		try (DataInputStream stream = new DataInputStream(new FileInputStream(file))){
			person.setId(stream.readLong());
			person.setName(stream.readUTF());
			person.setPhoneNumber(stream.readUTF());
			person.setSalary(stream.readDouble());
			person.setAge(stream.readInt());
			//me trae ese valor en byte
			//byte[] bytes = new byte[(int)file.length()];
			byte[] bytes = new byte [stream.available()];

			for (byte b : bytes) {
				System.out.println(b);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
		return person;
	}

	private static void writePerson(String path, Person person) {
		try(DataOutputStream stream = new DataOutputStream(new FileOutputStream(path))){
			stream.writeUTF(revertName(person.getName(), " "));
			stream.writeDouble(newSalary(person.getSalary()));
			stream.writeInt(newAge(person.getAge()));
			stream.writeUTF(person.getPhoneNumber());
			stream.writeLong(newId(person.getId()));

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace());
		}
	}


	private static String revertName(String Name, String useDecode) {
		StringBuilder builder = new StringBuilder();
		String[] names = Name.split(useDecode);

		for (int i = names.length - 1; i >= 0; i--) {
			builder.append(names[i]).append(" ");
		}
		return builder.toString();
	}

	private static double newSalary(double salary) {
		return salary / 2;
	}

	private static int newAge(int age) {
		return age-10;
	}

	private static long newId(long id) {
		return id*2;
	}

	private static Person readNewPerson(String path) {
		Person newPerson = new Person();
		try (DataInputStream stream = new DataInputStream(new FileInputStream(path))) {
			newPerson.setName(stream.readUTF());
			newPerson.setSalary(stream.readDouble());
			newPerson.setAge(stream.readInt());
			newPerson.setPhoneNumber(stream.readUTF());
			newPerson.setId(stream.readLong());
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
		return newPerson;
	}

	public static void main(String[] args) {
		Person oldPerson = readPerson("src/resources/input/person.bin");
		writePerson ("src/resources/output/new-person.ddr", oldPerson);
		System.out.println(oldPerson);

		System.out.println("\n" + "Modificado: ");
		Person newPerson = readNewPerson("src/resources/output/new-person.ddr");
		System.out.println(newPerson);
	}

}