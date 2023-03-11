package co.edu.uptc.activity.two.third;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;

public class ThirdActivity {
	
	public  static byte[] getEncodeBytes(String path) throws IOException{
		
		DataInputStream input= new DataInputStream(new FileInputStream(path));
			byte[] ImageDecodificated = Base64.getDecoder().decode(input.readAllBytes()) ;
			 	input.close();
		return ImageDecodificated;
	}
	public static void writeImage(String save,byte[]bytes) throws IOException {
		DataOutputStream  output = new DataOutputStream(new FileOutputStream(save));
		output.write(bytes);
		output.close();
	}
	public static void main(String[] args) throws IOException {
		String path = "src\\resources\\\\input\\base64.txt";
		String save = "src\\resources\\input\\imagen.jpg";
		ThirdActivity.writeImage(save, ThirdActivity.getEncodeBytes(path));
		
	}

}
