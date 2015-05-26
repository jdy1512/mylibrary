package mybatis.hr.test;

import java.util.List;

import mybatis.hr.dao.EmployeeDAO;
import mybatis.hr.vo.Employee;

public class TestEmployee {
	public static void main(String[] args) {
		EmployeeDAO dao = EmployeeDAO.getInstance();
		List<Employee> list = dao.selectAllEmployees();
		for (Employee e : list) {
			System.out.println(e);
			System.out.println(e.getDepartment());
			System.out.println("--------------------------------------------");
		}
	}
}
