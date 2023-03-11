package co.edu.uptc.activity.two.second;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity {

	/**
	 * metodo para leer un archivo binario y retornar un objeto persona
	 * 
	 * @param path
	 * @return objeto persona
	 */
	private static Person readPerson(String path) {
		Person person = new Person();
		// File file = new File(path);
		try (DataInputStream stream = new DataInputStream(new FileInputStream(path))) {
			// byte[] fileContent = new byte[stream.available()];
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

	/**
	 * metodo para leer un archivo .ddr y retornar un objeto persona
	 * 
	 * @param path
	 * @return nuevo objeto persona
	 */
	private static Person readNewPerson(String path) {
		Person newPerson = new Person();
		// File file = new File(path);
		try (DataInputStream stream = new DataInputStream(new FileInputStream(path))) {
			newPerson.setFullName(stream.readUTF());
			newPerson.setSalary(stream.readDouble());
			newPerson.setAge(stream.readInt());
			newPerson.setPhoneNumber(stream.readUTF());
			newPerson.setId(stream.readLong());
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
		return newPerson;
	}

	/**
	 * metodo para escribir una nueva persona en un archivo .ddr
	 * 
	 * @param path
	 * @param person
	 */
	private static void writeNewPerson(String path, Person person) {
		try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(path))) {
			stream.writeUTF(revertFullName(person.getFullName(), " "));
			stream.writeDouble(newSalary(person.getSalary()));
			stream.writeInt(newAge(person.getAge()));
			stream.writeUTF(person.getPhoneNumber());
			stream.writeLong(newId(person.getId()));
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
	}

	/**
	 * metodo para calcular la nueva edad de una persona
	 * 
	 * @param age
	 * @return nueva edad
	 */
	private static int newAge(int age) {
		return age - 10;
	}

	/**
	 * 
	 * @param id
	 * @return nuevo id
	 */
	private static long newId(long id) {
		return id * 2;
	}

	/**
	 * metodo para revertir el nombre de una persona, iniciando del ultimo apellido
	 * y finalizando en el primer nombre
	 * 
	 * @param fullName
	 * @param useDecode
	 * @return nombre completo revertido
	 */
	private static String revertFullName(String fullName, String useDecode) {
		StringBuilder builder = new StringBuilder();
		String[] names = fullName.split(useDecode);
		for (int i = names.length - 1; i >= 0; i--) {
			builder.append(names[i]).append(" ");
		}
		return builder.toString();
	}

	/**
	 * metodo para calcular el nuevo salario de una persona
	 * 
	 * @param salary
	 * @return nuevo salario
	 */
	private static double newSalary(double salary) {
		return salary / 2;
	}

	public static void main(String[] args) {
		Person oldPerson = readPerson("src/resources/input/person.bin");
		writeNewPerson("src/resources/output/new-person.ddr", oldPerson);
		System.out.println(oldPerson);
		Person newPerson = readNewPerson("src/resources/output/new-person.ddr");
		System.out.println(newPerson);
	}
}
