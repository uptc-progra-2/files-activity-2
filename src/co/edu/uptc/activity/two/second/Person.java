package co.edu.uptc.activity.two.second;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 */
public class Person implements Serializable {

    private String nombresApellidos;
    private String telefono;
    private Double salario;
    private int edad;
    private long id;

    public Person(String nombresApellidos, String telefono, Double salario, int edad, long id) {
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

    public void restarEdad() {
        edad -= 10;
    }

    public void multiplicarId() {
        id *= 2;
    }

    public void invertirNombresApellidos() {
        String[] nombresApellidosArray = nombresApellidos.split(" ");
        if (nombresApellidosArray.length >= 2) {
            nombresApellidos = nombresApellidosArray[1] + " " + nombresApellidosArray[0];
        }
    }

    public void dividirSalario() {
        salario /= 2;
    }

    public void escribirEnArchivo(String rutaArchivo) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(rutaArchivo, true))) {
            dos.writeUTF(nombresApellidos);
            dos.writeDouble(salario);
            dos.writeInt(edad);
            dos.writeUTF(telefono);
            dos.writeLong(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

