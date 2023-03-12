package co.edu.uptc.activity.two.first;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FirstActivity {
	//Buscar Un componenete dentro de un txt arreglo 
	private static final String[] VOWELS = {"a","e","i","o","u"};
	
	private static boolean isVowel(String carcater) {
		return Arrays.binarySearch(VOWELS, carcater)>=0;
	}
	
	private static int conuntVowels(String path){
		File file = new File(path);
		int counter=0;
		try(FileReader reader = new FileReader(file)) {
			int content;
			while((content = reader.read())!= -1) {
				String caracter = ((char) content+"").toLowerCase();
				if(isVowel(caracter)) {
					counter++;
				}
			}
			 
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		return counter;
	}
	
	public static void main(String[] args) {
		System.out.println("El archivo tiene "+ conuntVowels("resources/input/texto.txt")+"vocales");

	}
}
