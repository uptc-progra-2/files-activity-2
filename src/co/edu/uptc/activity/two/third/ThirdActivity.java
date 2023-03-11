package co.edu.uptc.activity.two.third;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class ThirdActivity {

	private static String readFile(String path) {
		File file = new File(path);
		StringBuilder builder = new StringBuilder();
		try (Scanner scanner =  new Scanner(file)){
			scanner.useDelimiter("\n");
			while (scanner.hasNextLine()) {
				builder.append(scanner.next());
			}
		} catch (Exception e) {
			System.out.println("elemento no encontrado");
		}
		return builder.toString();
	}

	private static void writeImage(String path, byte[] imageBytes){
		try (DataOutputStream stream = new DataOutputStream(new FileOutputStream(path))) {
			stream.write(imageBytes);
		} catch (Exception e) {
			System.out.println("elemento no encontrado");
		}
	}
	public static void main(String[] args) {
		String base64 = readFile("src/resources/input/base64.txt");
		System.out.println(base64);
		byte[] imageBytes = java.util.Base64.getDecoder().decode(base64);
		writeImage("src/resources/output/image.jpg", imageBytes);
	}

}
