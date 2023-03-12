package co.edu.uptc.activity.two.four;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FourActivity {
	
	public static void readFile(String path) throws IOException {

		File file = new File (path);
		int count = 0;
		byte datos_entrada [] = new byte [209573]; 

		try (FileInputStream stream = new FileInputStream(file)){

			boolean finArchive = false;

			while (!finArchive) {
				int byteEntrada = stream.read();

				//	if(byteEntrada == -1)
				//		finArchive = true;

				if (byteEntrada != -1) {
					datos_entrada[count] =(byte) byteEntrada;
				} else {
					finArchive = true;
				}
				count++;
			}

			stream.close();
		} catch (Exception e) {
			System.out.println("Error.");
		}
			System.out.println("Total bytes: " +count);
			// Escribimos el string codificado en Base64 en un archivo de salida
			String base64String = Base64.getEncoder().encodeToString(datos_entrada);
		    String outputFilePath = "src/resources/output/940-base64.txt";
		    FileOutputStream newArchive = new FileOutputStream(outputFilePath);
		    newArchive.write(base64String.getBytes());
		    newArchive.close();
		    
		    System.out.println("Archivo generado en 'resources.output', es necesario reiniciar eclipse para verlo.");
	}

	public static void main(String[] args) throws IOException {
		
		readFile("src/resources/input/940.jpg");	
		
	}
	
//	  Forma dos.
//    public static void main(String[] args) {
//        // Ruta de la imagen
//        String imgPath = "src/resources/input/940.jpg";
//
//        // Crear un objeto File con la ruta de la imagen
//        File file = new File(imgPath);
//
//        try (FileInputStream stream = new FileInputStream(file)){
//            // Crear un objeto FileInputStream con el archivo
//            
//            // Crear un arreglo de bytes para almacenar los datos leídos
//            byte[] data = new byte[(int) file.length()];
//
//            // Leer los datos del archivo y almacenarlos en el arreglo de bytes
//            stream.read(data);
//
//            // Cerrar el FileInputStream
//            stream.close();
//
//            // Codificar el arreglo de bytes a Base64
//            String base64String = Base64.getEncoder().encodeToString(data);
//
//            // Escribir el string codificado en Base64 en un archivo de salida
//            String outputFilePath = "src/resources/output/940-base64.txt";
//            FileOutputStream newArchive = new FileOutputStream(outputFilePath);
//            newArchive.write(base64String.getBytes());
//            newArchive.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Archivo creado. (Para poder verlo es necesario reiniciar eclipse)");
//    }

}
