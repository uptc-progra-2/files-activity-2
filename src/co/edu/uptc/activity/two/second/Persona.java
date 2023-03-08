package co.edu.uptc.activity.two.second;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class Persona implements Serializable {
	private String nombresApellidos;
	private String telefono;
	private Double salario;
	private int edad;
	private long id;

	public Persona(String nombresApellidos, String telefono, Double salario, int edad, long id) {
		this.nombresApellidos = nombresApellidos;
		this.telefono = telefono;
		this.salario = salario;
		this.edad = edad;
		this.id = id;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void actualizarDatos() {
		this.edad -= 10;
		this.id *= 2;
		String[] nombreApellido = this.nombresApellidos.split(" ");
		this.nombresApellidos = nombreApellido[1] + " " + nombreApellido[0];
		this.salario /= 2;
	}

	public void escribirEnArchivo(DataOutputStream archivo) throws IOException {
		archivo.writeUTF(this.nombresApellidos);
		archivo.writeDouble(this.salario);
		archivo.writeInt(this.edad);
		archivo.writeUTF(this.telefono);
		archivo.writeLong(this.id);
	}

	public static Persona leerDesdeArchivo(DataInputStream archivo) throws IOException {
		String nombresApellidos = archivo.readUTF();
		Double salario = archivo.readDouble();
		int edad = archivo.readInt();
		String telefono = archivo.readUTF();
		long id = archivo.readLong();

		return new Persona(nombresApellidos, telefono, salario, edad, id);
	}
}