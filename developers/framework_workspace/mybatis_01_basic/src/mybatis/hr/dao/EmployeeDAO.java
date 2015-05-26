package mybatis.hr.dao;

import java.util.List;

import mybatis.hr.common.DatabaseManager;
import mybatis.hr.vo.Employee;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	
	private SqlSessionFactory sessionFactory;
	private String namespace = "mybatis.hr.dao.employee.";
	
	public static EmployeeDAO getInstance() {
		return instance;
	}
	
	private EmployeeDAO() {
		sessionFactory = DatabaseManager.getInstance().getSqlSessionFactory();
	}
	
	public List<Employee> selectAllEmployees() {
		SqlSession session = sessionFactory.openSession();
		try {
			return session.selectList(namespace + "selectAllEmployees");
		} finally {
			session.close();
		}
	}
}
