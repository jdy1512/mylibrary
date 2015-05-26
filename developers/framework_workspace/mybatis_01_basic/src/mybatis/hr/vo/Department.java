package mybatis.hr.vo;

import java.util.List;

public class Department {
	private int departmentId;
	private String departmentName;
	private String location;
	/**
	 * 조회한 Employee(조인관계) 들을 담을 property 설정 - 1:N join - list
	 */
	private List<Employee> employees;

	public Department() {
	}

	public Department(int departmentId, String departmentName, String location,
			List<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.location = location;
		this.employees = employees;
	}

	/**
	 * @return the departmentId
	 */
	public int getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId
	 *            the departmentId to set
	 */
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName
	 *            the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees
	 *            the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName="
				+ departmentName + ", location=" + location + "]";
	}

}
