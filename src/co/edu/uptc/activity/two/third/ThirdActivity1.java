package co.edu.uptc.activity.two.third;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Base64;

public class ThirdActivity1 {

	private static String readImage(String path) {
		String base64 = "";
		File file = new File(path);
		try (FileInputStream input = new FileInputStream(file)) {
			byte[] imageBytes = new byte[(int) file.length()];
			input.read(imageBytes);
			base64 = Base64.getEncoder().encodeToString(imageBytes);
		} catch (Exception e) {
			System.out.println("Archivo no encontrado");
		}
		return base64;
	}

	private static void writeFile(String base64, String path) {
		try (FileWriter writer = new FileWriter(path)) {
			writer.write(base64);
		} catch (Exception e) {
			System.out.println("Archivo no encontrado");
		}
	}

	public static void main(String[] args) {
		String base64 = readImage("src/resources/input/940.jpg");
		System.out.println(base64);
		writeFile(base64, "src/resources/output/940-base64.txt");
	}
}
