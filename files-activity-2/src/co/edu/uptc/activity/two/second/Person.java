package co.edu.uptc.activity.two.second;

public class Person {
	private String fullName;
	private String phone;
	private double salary;
	private int age;
	private long id;
	
	public Person() {
		
	}
	public Person(String fullNanme, String phone, double salary, int age, long id) {
		super();
		this.fullName = fullNanme;
		this.phone = phone;
		this.salary = salary;
		this.age = age;
		this.id = id;
	}
	

	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

