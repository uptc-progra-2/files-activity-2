package co.edu.uptc.activity.two.third;

//import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileReader;
import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.Base64;
import java.util.Scanner;

public class ThirdActivity {
	
	private static String readFile(String path) {
		StringBuilder builder = new StringBuilder();
		File file = new File(path);
		try(Scanner sc = new Scanner(file)){
			//Hacemos el salto para empezar a leer otra linea
			sc.useDelimiter("\n");
			while (sc.hasNext()) {
				builder.append(sc.next());
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
	
	private static void writeImg(String path, byte[] imgBytes) {
		try(DataOutputStream data = new DataOutputStream(new FileOutputStream(path))){
			data.write(imgBytes);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String base64 = readFile("src/resources/input/base64.txt");
		System.out.println(base64);
		System.out.println("Imagen creada en el paquete 'resources.output'. Para poder verla se necesita reiniciar eclipse.");
		byte[] imgBytes = Base64.getDecoder().decode(base64);
		writeImg("src/resources/output/imagen.jpg", imgBytes);
	}

//  Forma 1.
//	public static void main(String[] args) throws IOException {
//		FileReader fr = new FileReader("src/resources/input/base64.txt");
//		BufferedReader br = new BufferedReader(fr);
//
//		String line = br.readLine();
//		
//		// getDecoder() porque se requiere decodificarlo
//		// Puedo usar la clase Base64 para convertir un String en base64 a un arreglo de bytes
//		byte[] bytes = Base64.getDecoder().decode(line);
//		
//		if (br != null) {
//			br.close();
//		}
//		
//		FileOutputStream fileO = new FileOutputStream("src/resources/output/imagen5.jpg");
//		DataOutputStream stream = new DataOutputStream(fileO);
//		
//		stream.write(bytes);
//		
//		stream.close();
//	}
	
//		Forma 2.
//		public static void main(String[] args) throws Exception {
//	
//			//Estamos Decodificando
//			// Leer el archivo base64.txt y almacenar su contenido en un objeto String.
//			String base64String = new String(Files.readAllBytes(Paths.get("C:\\Users\\Samir\\Downloads\\files-activity-2-samir_molinares\\files-activity-2-samir_molinares\\src\\resources\\input\\base64.txt")), StandardCharsets.UTF_8);
//	
//			// Decodificar el string base64 a un arreglo de bytes.
//			byte[] bytes = Base64.getDecoder().decode(base64String);
//	
//			// Crear un archivo nuevo y escribir los bytes decodificados utilizando la clase DataOutputStream.
//			DataOutputStream stream = new DataOutputStream(new FileOutputStream("C:\\Users\\Samir\\Downloads\\files-activity-2-samir_molinares\\files-activity-2-samir_molinares\\src\\resources\\output\\imagen.jpg"));
//			stream.write(bytes);
//			stream.close();
//		}

}