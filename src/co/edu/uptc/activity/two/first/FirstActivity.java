package co.edu.uptc.activity.two.first;
import java.io.*;

public class FirstActivity {

	//Metodo que recibe como parametro una letra y lo que hace es convertir cada caracter en minuscula y luego compara 
	//si pertenece a alguna vocal, si es igual a una vocal me retorna verdadero.
	public boolean checkoutVocable(char letter) {
		boolean isVocable = false;
		String abc = (letter + "").toLowerCase();
		String[] vowels = {"a","e","i","o","u"};
		for (String str : vowels) {
			if (str.equals(abc)) {
				isVocable=true;
			}
		}
		return isVocable;
	}

	public void run(String path) {
		int character;
		int count = 0;
		File file = new File(path);
		try (FileReader reader = new FileReader(file)){
			//FileReader file = new FileReader(new File("C:\\Users\\Samir\\Downloads\\files-activity-2-samir_molinares\\files-activity-2-samir_molinares\\src\\resources\\input\\texto.txt"));

			while((character = reader.read())!= -1) {
				if (this.checkoutVocable((char)character)) {
					count++;
				}
			}

			reader.close();
			System.out.println("El numero total de vocales es de: " + count);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FirstActivity().run("src/resources/input/texto.txt");

	}

}
