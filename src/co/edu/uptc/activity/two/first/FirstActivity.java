package co.edu.uptc.activity.two.first;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class FirstActivity {

	public static void main(String[] args) {
		try (DataInputStream dis=new DataInputStream(new FileInputStream("C:\\Users\\pc\\Desktop\\UPTC\\TERCER SEMESTRE\\PROGRAMACIÓN II\\files-activity-2\\src\\resources\\input\\texto.txt"));){
			System.out.println("Datos en el archivo");
			//Lee el primer byte
			int ch=dis.read();
			while (ch !=-1) {
				System.out.println(ch);
				//Lee el siguiente byte del archivo
				ch=dis.read();
			}
			dis.close();
		} catch (Exception e) {
			e.getStackTrace();
		} 
	}
}
