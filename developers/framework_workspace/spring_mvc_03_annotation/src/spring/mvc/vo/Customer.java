package spring.mvc.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String password;
	private String name;
	private String email;
	private int salary;
	private boolean marriage;
	private String[] hobby;
	private List<Object> interest;

	public Customer() {
	}

	public Customer(String id, String password, String name, String email,
			int salary, boolean marriage, String[] hobby, List<Object> interest) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.salary = salary;
		this.marriage = marriage;
		this.hobby = hobby;
		this.interest = interest;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean isMarriage() {
		return marriage;
	}

	public void setMarriage(boolean marriage) {
		this.marriage = marriage;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public List<Object> getInterest() {
		return interest;
	}

	public void setInterest(List<Object> interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", password=" + password + ", name="
				+ name + ", email=" + email + ", salary=" + salary
				+ ", marriage=" + marriage + ", hobby="
				+ Arrays.toString(hobby) + ", interest=" + interest + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + Arrays.hashCode(hobby);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((interest == null) ? 0 : interest.hashCode());
		result = prime * result + (marriage ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (!Arrays.equals(hobby, other.hobby))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (interest == null) {
			if (other.interest != null)
				return false;
		} else if (!interest.equals(other.interest))
			return false;
		if (marriage != other.marriage)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

}
