package co.edu.uptc.activity.two.third;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class ThirdActivity {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("src//resources//input/base64.txt");
		BufferedReader br = new BufferedReader(fr);

		String line = br.readLine();
		
		// getDecoder() porque necesito decodificarlo
		// Puedo usar la clase Base64 para convertir un String en base64 a un arreglo de bytes
		byte[] bytes = Base64.getDecoder().decode(line);
		
		if (br != null) {
			br.close();
		}
		
		FileOutputStream fos = new FileOutputStream("src//resources//output//imagen.jpg");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.write(bytes);
		
		dos.close();
	}

}
