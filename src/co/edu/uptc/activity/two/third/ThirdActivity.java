package co.edu.uptc.activity.two.third;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

public class ThirdActivity {
	
	public static String readFile(String path) {
		StringBuilder builder= new StringBuilder();
		File file =new File(path);
		try(Scanner scanner=new Scanner(file)){
			scanner.useDelimiter("\n");//HAce el salto para empezar a leer otra línea
			while (scanner.hasNext()) {
				builder.append(scanner.next());
			}
		}catch(IOException e){
			System.err.println(e.getStackTrace());
		}
		return builder.toString();
	}
	private static void writeImage(String path, byte[]imageBytes) {
		try (DataOutputStream stream=new DataOutputStream(new FileOutputStream(path))){
			stream.write(imageBytes);
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
	}
	
	public static void main(String[] args) {
		String base64=readFile("src/resources/input/base64.txt");
		System.out.println(base64);
		byte[] imagesBytes=Base64.getDecoder().decode(base64);
		writeImage("src/resources/output/image.jpg",imagesBytes);
	}

}
