package co.edu.uptc.activity.two.first;
import java.io.*;

public class FirstActivity {

	//Metodo que recibe como parametro una letra y lo que hace es convertir cada caracter en minuscula y luego compara 
	//si pertenece a alguna vocal, si es igual a una vocal me retorna verdadero.
	public boolean checkoutVocable(char letter) {
		boolean isVocable = false;
		String aei = (letter + "").toLowerCase();
		String[] vowels = {"a","e","i","o","u"};
		for (String str : vowels) {
			if (str.equals(aei)) {
				isVocable=true;
			}
		}
		return isVocable;
	}

	public void run() {
		int character;
		int count = 0;

		try {
			FileReader file = new FileReader(new File("C:\\Users\\USER\\Desktop\\monoo\\samir\\files-activity-2\\src\\resources\\input\\texto.txt"));

			//
			while((character = file.read())!= -1) {
				if (this.checkoutVocable((char)character)) {
					count++;
				}
			}

			file.close();
			System.out.println("El numero total de vocales es de: " + count);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new FirstActivity().run();

	}

}
