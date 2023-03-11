package co.edu.uptc.activity.two.fourth;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import co.edu.uptc.activity.two.third.ThirdActivity;

public class FourthActivity {
	public  static byte[] getDecodedBytes(String path) throws IOException{
		
		DataInputStream input= new DataInputStream(new FileInputStream(path));
		byte[] imageBytes =  input.readAllBytes();
		input.close();
		return imageBytes;
				
	}
	public static void encodeBytesToString(String save ,byte[] bytes) throws IOException {
		BufferedWriter writer  = new BufferedWriter(new FileWriter(save));
		String encodeImage = Base64.getEncoder().encodeToString(bytes);
		writer.write(encodeImage);
		writer.close();
	}
	public static void main(String[] args) throws IOException {
		String path = "src\\resources\\\\input\\940.jpg";
		String save = "src\\resources\\output\\940-base64.txt"; 
		FourthActivity.encodeBytesToString(save, FourthActivity.getDecodedBytes(path));
		
	}
}
