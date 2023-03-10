package co.edu.uptc.activity.two.fourth;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FourthActivity {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("src//resources//input//940.jpg");
			DataInputStream dis = new DataInputStream(fis);
			
			byte[] bytes = dis.readAllBytes();
			
			// getEncoder() porque necesito codificarlo 
			// Método encodeToString() para pasar un arreglo de bytes a un String en base64
			String line = Base64.getEncoder().encodeToString(bytes);
			
			FileOutputStream fos = new FileOutputStream("src//resources//output//940-base64.txt");
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeBytes(line);
			
		} catch (IOException o) {
			o.printStackTrace();
		}

	}

}
