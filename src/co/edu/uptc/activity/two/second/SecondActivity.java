package co.edu.uptc.activity.two.second;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\USER\\Desktop\\monoo\\samir\\files-activity-2\\src\\resources\\input\\person.bin";
        String outputFile = "C:\\Users\\USER\\Desktop\\monoo\\samir\\files-activity-2\\src\\resources\\output\\new-person.ddr";

        try (DataInputStream input = new DataInputStream(new FileInputStream(inputFile));
             DataOutputStream output = new DataOutputStream(new FileOutputStream(outputFile))) {

            while (input.available() > 0) {
                Persona persona = Persona.leerDesdeArchivo(input);
                persona.actualizarDatos();
                persona.escribirEnArchivo(output);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}