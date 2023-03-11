package co.edu.uptc.activity.two.first;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FirstActivity {
	private String path = "../files_activity_2/src/resources/input/texto.txt";
	private int counter;
	private static final String[] VOWELS= {"a","e","i","o","u"};

	public int getVowelsNumber() {
		try {
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = bufferedReader.readLine();
			while (line != null) {
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o'
							|| line.charAt(i) == 'u' || line.charAt(i) == 'A' || line.charAt(i) == 'E'
							|| line.charAt(i) == 'I' || line.charAt(i) == 'O' || line.charAt(i) == 'U') {
						counter++;
					}
				}
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return counter;
	}

	
	private static boolean isvowel(String character) {
		return Arrays.binarySearch(VOWELS, character) >= 0;
	}

	
	public static int getVowelsNumber2(String path) {
		File file = new File(path);
		// char c = new Char[];
		int counter = 0;
		try (FileReader fileReader = new FileReader(file);) {
			int content;
			while ((content = fileReader.read()) != -1) {
				String character = (char) content + "";
				if (isvowel(character.toLowerCase())) {
					counter++;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return counter;
	}

	public static void main(String[] args) {
		FirstActivity firstActivity = new FirstActivity();
		System.out.println("Total de vocales: " + getVowelsNumber2("src/resources/input/texto.txt"));
	}
}
