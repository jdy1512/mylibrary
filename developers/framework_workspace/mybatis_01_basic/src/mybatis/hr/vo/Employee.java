package mybatis.hr.vo;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	private int employeeId;
	private String employeeName;
	private String email;
	private String jobPosition;
	private long salary;
	private Date hireDate;
	private int departmentId;// 부모테이블(department)의 PK -> d_id, d_name, loc
	private Department department;// 직원이 다니는 부서의 데이터를 넣을 VO

	public Employee() {
	}

	public Employee(int employeeId, String employeeName, String email,
			String jobPosition, long salary, Date hireDate, int departmentId,
			Department department) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.jobPosition = jobPosition;
		this.salary = salary;
		this.hireDate = hireDate;
		this.departmentId = departmentId;
		this.department = department;
	}

	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName
	 *            the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the jobPosition
	 */
	public String getJobPosition() {
		return jobPosition;
	}

	/**
	 * @param jobPosition
	 *            the jobPosition to set
	 */
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	/**
	 * @return the salary
	 */
	public long getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(long salary) {
		this.salary = salary;
	}

	/**
	 * @return the hireDate
	 */
	public Date getHireDate() {
		return hireDate;
	}

	/**
	 * @param hireDate
	 *            the hireDate to set
	 */
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
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
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", email=" + email + ", jobPosition="
				+ jobPosition + ", salary=" + salary + ", hireDate=" + hireDate
				+ ", departmentId=" + departmentId + ", department="
				+ department + "]";
	}

}
