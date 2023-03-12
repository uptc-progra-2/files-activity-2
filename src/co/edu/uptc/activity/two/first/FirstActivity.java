package co.edu.uptc.activity.two.first;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FirstActivity {
	private static final String[] VOWELS= {"a","e","i","o","u"};
	
	private static boolean isVowell(String caracter) {
		return Arrays.binarySearch(VOWELS, caracter)>=0;//Yo mando el arreglo y me dice la posición del caracter
	}
	
	private static int countVowels(String path) {
		File file=new File(path);
		//ARREGLO DE CHAR PARA MANDAR LOS CARACTERES A UN ARREGLO
//		char[] caracteres=new char[(int) file.length()];
		int counter=0;
		try (FileReader reader =new FileReader(file)){
			int content;

			while((content=reader.read())!= -1) {
				String caracter= ((char)content+"").toLowerCase();
				if(isVowell(caracter)) {
					counter++;
				}
			}
		} catch (IOException e) {
			System.err.println(e.getStackTrace());
		}
		return counter; 
	}

	public static void main(String[] args) {
		System.out.println("El archivo tiene "+ countVowels("src/resources/input/texto.txt")+ " vocales");
	}
}
