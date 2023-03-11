package co.edu.uptc.activity.two.third;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Base64;

public class ThirdActivity {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("src/resources/input/base64.txt"));
		String base64 = reader.readLine();
		reader.close();
		byte[] bytes = Base64.getDecoder().decode(base64);
		FileOutputStream outputStream = new FileOutputStream("src/resources/output/imagen2.jpg");
		DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
		dataOutputStream.write(bytes);
		dataOutputStream.close();
		outputStream.close();
	}
}
