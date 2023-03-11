package co.edu.uptc.activity.two.third;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Base64;

public class ThirdActivity2 {

    /**
     * Metodo para leer una imagen y convertirla en base64
     * @param path
     * @return texto en base64
     */
    private static String readImage(String path) {
        String base64 = "";
        File file = new File(path);
        try (FileInputStream input = new FileInputStream(file)) {
            byte[] imageBytes = new byte[(int) file.length()];
            input.read(imageBytes);
            base64 = Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return base64;
    }

    /**
     * Metodo para escribir un archivo de texto.
     * @param base64 texto en base64
     * @param path ruta del archivo donde almacenaremos el texto
     */
    private static void writeFile(String base64, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(base64);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        String base64 = readImage("Workshop/files-activity-2/src/resources/input/940.jpg");
        System.out.println(base64);
        writeFile(base64, "Workshop/files-activity-2/src/resources/output/940-base64.txt");
    }
}
