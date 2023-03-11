package co.edu.uptc.activity.two.second;

public class Person {
	


	private String name;

	private String phone;
	
	private double salary;
	
	private int age;
	
	private long id;
	
	public Person(long id,String names,  String phone, double salary,int age ) {
		
		this.name = names;
		this.phone = phone;
		this.salary = salary;
		this.age = age;
		this.id = id;
		
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
