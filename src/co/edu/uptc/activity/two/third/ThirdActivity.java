package co.edu.uptc.activity.two.third;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
public class ThirdActivity {
		public static void main(String[] args) {
			// Esto es para la lectura del archivo base64.txt
			String inputFile = "src/resources/input/base64.txt";
			byte[] inputBytes = null;
			try {
				inputBytes = Files.readAllBytes(Paths.get(inputFile));
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}

			// Aqui se realiza la decodificación del archivo base64.txt a bytes
			byte[] decodedBytes = Base64.getDecoder().decode(inputBytes);

			// aqui se realiza la escritura del archivo imagen.jpg en la carpeta output
			String outputFile = "src/resources/output/imagen.jpg";
			try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(outputFile))) {
				outputStream.write(decodedBytes);
				System.out.println("Se ha generado el archivo " + outputFile);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}

			//despues se lee el archivo 940.jpg
			String imageFile = "src/resources/input/940.jpg";
			byte[] imageBytes = null;
			try {
				imageBytes = Files.readAllBytes(Paths.get(imageFile));
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}

			// aqui se hace lo de la codificación del archivo 940.jpg a base64
			String encodedString = Base64.getEncoder().encodeToString(imageBytes);

			// aqui se vuelve hacer la escritura del archivo 940-base64.txt en la carpeta output
			String base64File = "src/resources/output/940-base64.txt";
			try (PrintWriter writer = new PrintWriter(base64File)) {
				writer.write(encodedString);
				System.out.println("Se ha generado el archivo " + base64File);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



