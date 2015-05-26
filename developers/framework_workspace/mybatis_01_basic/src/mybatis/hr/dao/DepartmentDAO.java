package mybatis.hr.dao;

import java.util.List;
import java.util.Map;

import mybatis.hr.common.DatabaseManager;
import mybatis.hr.vo.Department;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DepartmentDAO {
	private static DepartmentDAO instance = new DepartmentDAO();

	private SqlSessionFactory sessionFactory;
	private String namespace = "mybatis.hr.dao.department.";

	private DepartmentDAO() {
		sessionFactory = DatabaseManager.getInstance().getSqlSessionFactory();
	}

	public static DepartmentDAO getInstance() {
		return instance;
	}

	public int insertDepartment(Department department) {
		//SqlSession - SQL문을 실행하는 메소드들을 제공.
		SqlSession session = sessionFactory.openSession();
		try {
			int cnt = session.insert(namespace + "insertDepartment", department);
			session.commit();
			return cnt;
		} finally {
			session.close();// DB관련 자원 반납
		}
	}
	
	public Map selectMemberByIdMap(int departmentId) {
		SqlSession session = sessionFactory.openSession();
		Map map = null;
		try {
			map = session.selectOne(namespace + "selectDepartmentById", departmentId);
			return map;
		} finally {
			session.close();// DB관련 자원 반납
		}
	}
	
	public int updateDepartment(Department department) {
		// 1. SqlSession생성 - Session(SQL작업) 시작
		SqlSession session = sessionFactory.openSession();
		
		try {
			// 2. SQL문 실행 - insert(), update(), delete(), selectOne(), selectList()||selectMap()
			int cnt = session.update(namespace + "updateDepartment", department);
			session.commit();
			return cnt;
		} finally {
			
		}
	}
	
	public int deleteDepartmentById(int departmentId) {
		SqlSession session = sessionFactory.openSession();
		try {
			int cnt = session.delete(namespace + "deleteDepartmentById", departmentId);
			session.commit();
			return cnt;
		} finally {
			session.close();// DB관련 자원 반납
		}
	}
	
	public int deleteDepartmentByLocation(String lcoation) {
		SqlSession session = sessionFactory.openSession();
		try {
			int cnt = session.delete(namespace + "deleteDepartmentByLocation", lcoation);
			session.commit();
			return cnt;
		} finally {
			session.close();// DB관련 자원 반납
		}
	}
	
	public List<Department> selectDepartmentsList() {
		SqlSession session = sessionFactory.openSession();
		List<Department> list = null;
		try {
			list = session.selectList(namespace + "selectDepartmentsList");
			return list;
		} finally {
			session.close();// DB관련 자원 반납
		}
	}
	
	public Map<Integer, Department> selectDepartmentsList_Map() {
		SqlSession session = sessionFactory.openSession();
		try {
			// selectMap() : 1.sql문 ID, 2.parameter,
			//				 3.map의 key로 사용할 property(PK값을 저장한 Property지정)
			Map<Integer, Department> map = session.selectMap(namespace + "selectDepartmentsList", null, "departmentId");
			return map;
		} finally {
			session.close();// DB관련 자원 반납
		}
	}
	
	public List selectRandom(String tableName) {
		SqlSession session = sessionFactory.openSession();
		try {
			return session.selectList(namespace + "selectRandom", tableName);
		} finally {
			session.close();
		}
	}
	
	public List<Department> selectDepartmentByName(String name) {
		SqlSession session = sessionFactory.openSession();
		try {
			return session.selectList(namespace + "selectDepartmentByName", name);
		} finally {
			session.close();
		}
	}
	
	public List<Department> selectDepartmentByLocation(String location) {
		SqlSession session = sessionFactory.openSession();
		try {
			return session.selectList(namespace + "selectDepartmentByLocation", location);
		} finally {
			session.close();
		}
	}

	public Department selectDepartmentById_JoinEmployee(int i) {
		SqlSession session = sessionFactory.openSession();
		try {
			return session.selectOne(namespace + "selectDepartmentById_JoinEmployee", i);
		} finally {
			session.close();
		}
	}
	
}