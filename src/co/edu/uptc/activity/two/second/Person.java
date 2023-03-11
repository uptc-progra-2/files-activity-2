package co.edu.uptc.activity.two.second;

public class Person {
    private String fullName;
    private String phoneNumber;
    private double salary;
    private int age;
    private long id;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person [Nombre= " + fullName + ", Telefono= " + phoneNumber + ", Salario= " + salary + ", Edad= " + age
                + ", id= " + id + "]";
    }
}
