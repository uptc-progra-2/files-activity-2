package co.edu.uptc.activity.two.first;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class FirstActivity {

	public static void main(String[] args) {
		/**
		 * Se instancia la ruta del archivo: con un String que llamamos
		 */
				String philePath = "src/resources/input/texto.txt";
		/**
		 * Se instancian las variables para necesarias para encontrart las
		 * vocales: "int numVolwes" para realizar el contador y "String vowles" para identificar las vocales tanto
		 * mayusculas como minusculqs
		 */
				int numVolwes = 0;
				String vowles = "aeiouAEIOU";

				try (BufferedReader br = new BufferedReader(new FileReader(philePath))) {

					// creamos una variable auxiliar para crear un metodo que lea linea por linea
					String line;
					while ((line = br.readLine()) != null) {

						// En esta seccion creamos el contador para que sume las vocales de cada liena
						for (int i = 0; i < line.length(); i++) {
							if (vowles.indexOf(line.charAt(i)) != -1) {
								numVolwes++;
							}
						}
					}

				} catch (IOException e) {
				}

				// Creamos un sout para mostrar lo que recolecto el contados (el conteo de vocales del archivo txt)
				System.out.println("El número de vocales en el archivo es: " +numVolwes);

			}

		}

