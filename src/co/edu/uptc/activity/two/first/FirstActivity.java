package co.edu.uptc.activity.two.first;


import com.sun.jdi.CharValue;

import java.io.FileReader;

import java.io.IOException;


public class FirstActivity {

	public static void main(String[] args) throws IOException {

		char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E','I','O','U'};
		try (FileReader fileReader = new FileReader("src/resources/input/texto.txt")) {
			int counter = 0;
			int content;
			while ((content = fileReader.read()) != -1) {

				for (int i = 0; i < vowels.length; i++) {
					if( content == vowels[i]){
					counter++;
					}
				}
				System.out.print((char) content);


			}
			System.out.println("En el texto hay " + counter + " vocales");
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	}


