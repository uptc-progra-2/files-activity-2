package co.edu.uptc.activity.two.four;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;


//Como pasar de rutas absolutas a rutas relativas
public class FourActivity {
	//Estamos codificando
	public static void main(String[] args) throws Exception {
		// Ruta del archivo de entrada
		String inputPath = "C:\\Users\\USER\\Desktop\\monoo\\samir\\files-activity-2\\src\\resources\\input\\940.jpg";
		// Ruta del archivo de salida
		String outputPath = "C:\\Users\\USER\\Desktop\\monoo\\samir\\files-activity-2\\src\\resources\\output\\940-base64.txt";

		// Leer el archivo de entrada como un arreglo de bytes
		byte[] inputBytes = Files.readAllBytes(Paths.get(inputPath));

		// Codificar el arreglo de bytes a Base64
		String base64String = Base64.getEncoder().encodeToString(inputBytes);

		// Escribir el string codificado en Base64 en el archivo de salida
		Path outputFilePath = Paths.get(outputPath);
		Files.write(outputFilePath, base64String.getBytes());
	}
}
