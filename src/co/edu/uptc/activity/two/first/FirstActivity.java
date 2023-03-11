package co.edu.uptc.activity.two.first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FirstActivity {
	
	public static void main(String[] args) throws IOException {
		File file = new File("src\\resources\\input\\texto.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String aux="";
		String value ="";
		FileReader fr = new FileReader(file);
			while ((aux=br.readLine())!=null) {
				value+= aux;
			}
			value = value.toLowerCase();
			int count=0;
		for (int i = 0; i < value.length(); i++) {
			if(value.charAt(i)==97||value.charAt(i)==101||value.charAt(i)==105||value.charAt(i)==111||value.charAt(i)==117) {
				count++;
			}
		}
		System.out.println(count);
	}
}
