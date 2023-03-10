package co.edu.uptc.activity.two.second;

public class Person {
	private String name;
	private double salary;
	private int age;
	private String telephone;
	private long id;
	
	public Person(String name, double salary, int age, String telephone, long id) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.telephone = telephone;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
	
}
