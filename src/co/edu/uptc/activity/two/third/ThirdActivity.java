package co.edu.uptc.activity.two.third;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class ThirdActivity {
	public static void main(String[] args) throws Exception {

		//Estamos Decodificando
		// Leer el archivo base64.txt y almacenar su contenido en un objeto String.
		String base64String = new String(Files.readAllBytes(Paths.get("C:\\Users\\USER\\Desktop\\monoo\\samir\\files-activity-2\\src\\resources\\input\\base64.txt")), StandardCharsets.UTF_8);

		// Decodificar el string base64 a un arreglo de bytes.
		byte[] bytes = Base64.getDecoder().decode(base64String);

		// Crear un archivo nuevo y escribir los bytes decodificados utilizando la clase DataOutputStream.
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Users\\USER\\Desktop\\monoo\\samir\\files-activity-2\\src\\resources\\output\\imagen.jpg"));
		dos.write(bytes);
		dos.close();
	}
}