package co.edu.uptc.activity.two.second;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class SecondActivity {
	public static void main(String[] args) {
				String rutaEntrada = "src/resources/input/person.bin";
				String rutaSalida = "src/resources/output/new-person.ddr";

				try (DataInputStream dis = new DataInputStream(new FileInputStream(rutaEntrada))) {
					while (dis.available() > 0) {
						long id = dis.readLong();
						String nombresApellidos = dis.readUTF();
						String telefono = dis.readUTF();
						Double salario = dis.readDouble();
						int edad = dis.readInt();

						Person person = new Person(nombresApellidos, telefono, salario, edad, id);
						person.restarEdad();
						person.multiplicarId();
						person.invertirNombresApellidos();
						person.dividirSalario();
						person.escribirEnArchivo(rutaSalida);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	}

}