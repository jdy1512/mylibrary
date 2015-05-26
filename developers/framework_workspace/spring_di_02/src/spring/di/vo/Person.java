package spring.di.vo;

public class Person {
	private String id;
	private String name;
	private int age;
	private Address address;

	public Person(String id) {
		this.id = id;
	}

	public Person(int age) {
		this.age = age;
	}

	public Person(Address address) {
		this.address = address;
	}

	public Person(String id, String name, int age, Address address) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age
				+ ", address=" + address + "]";
	}

}
