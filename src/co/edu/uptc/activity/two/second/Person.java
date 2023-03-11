package co.edu.uptc.activity.two.second;

public class Person {

    private String fullName;
    private String phoneNumber;
    private double salary;
    private int age;
    private long id;

    /*
    * @param fullName
    * @param phoneNumber
    * @param salary
    * @param age
    * @param id
    * */

    public Person(String fullName, String phoneNumber, double salary, int age, long id){
        super();
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
        this.id = id;
    }
    public Person(){}

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public long getId() {
        return id;
    }
}
