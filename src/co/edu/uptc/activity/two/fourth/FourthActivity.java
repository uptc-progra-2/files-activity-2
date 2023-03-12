package co.edu.uptc.activity.two.fourth;

import java.util.Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FourthActivity {

	public static String encode(String imagePath) throws IOException {
		byte[] data =Files.readAllBytes(Paths.get(imagePath));
		return Base64.getEncoder().encodeToString(data);
	}
	
	public static byte[] decode (String base64String) {
		return Base64.getDecoder().decode(base64String);
	}
	
	public static void main(String[] args) throws IOException {
		String base64String="";
		try(FileWriter fileWriter=new FileWriter(new File("src/resources/output/940-base64.txt"))){;
		base64String=encode("src/resources/input/940.jpg");
		fileWriter.write(base64String);
		}
		try(FileOutputStream stream=new FileOutputStream(new File("src/resources/output/output.jpg"))){
			stream.write(decode(base64String));
		};
	}

}

