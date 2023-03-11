package co.edu.uptc.activity.two.fourth;

import java.io.*;
import java.util.Base64;

public class FourhtActivity {
    public static void main(String[] args) throws IOException {
        File file = new File("src/resources/input/940.jpg");
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            String encodedString = Base64.getEncoder().encodeToString(data);
            try (FileWriter writer = new FileWriter("src/resources/output/940-base64.txt")) {
                writer.write(encodedString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
