package co.edu.uptc.activity.two.first;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FirstActivity {

	public static void main(String[] args) {
		ArrayList<String> archiveLines = new ArrayList<String>();
		String lineRead = "";
		int count = 0;
		
		try {
			FileReader fr = new FileReader("src\\resources\\input\\texto.txt");
			BufferedReader br = new BufferedReader(fr);
			
			while ((lineRead = br.readLine()) != null) {
				archiveLines.add(lineRead + "\n");
			}
			
			if (br != null) {
				br.close();
			}
		} catch (IOException o) {
			o.printStackTrace();
		}
		
		for (String line : archiveLines) {
			line = line.toLowerCase(); 
			for (int i = 0; i < line.length(); i++) {
				char x = line.charAt(i);
				
				if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
					count++;
				}
			}
		}
		
		System.out.println("Cantidad de vocales: " + count);
		archiveLines.clear();
	}

}
