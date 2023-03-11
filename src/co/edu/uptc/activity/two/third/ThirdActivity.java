package co.edu.uptc.activity.two.third;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class ThirdActivity {

	/**
	 * metodo para leer un archivo de texto y retornar un string
	 * 
	 * @param path
	 * @return string
	 */
	private static String readFile(String path) {
		File file = new File(path);
		StringBuilder builder = new StringBuilder();
		try (Scanner scanner =  new Scanner(file)){
			scanner.useDelimiter("\n");
			while (scanner.hasNextLine()) {
				builder.append(scanner.next());
			}
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
		return builder.toString();
	}

	/**
	 * metodo para escribir una imagen en un archivo .jpg
	 * 
	 * @param path    ruta del archivo
	 * @param imageBytes arreglo de bytes de la imagen
	 */
	private static void writeImage(String path, byte[] imageBytes){
		try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(path))) {
			stream.write(imageBytes);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
	}
	public static void main(String[] args) {
		String base64 = readFile("Workshop/files-activity-2/src/resources/input/base64.txt");
		System.out.println(base64);
		byte[] imageBytes = java.util.Base64.getDecoder().decode(base64);
		writeImage("Workshop/files-activity-2/src/resources/output/imagen.jpg", imageBytes);
	}

}
