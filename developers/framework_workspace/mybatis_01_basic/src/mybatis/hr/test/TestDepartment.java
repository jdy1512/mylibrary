package mybatis.hr.test;

import java.util.List;

import mybatis.hr.dao.DepartmentDAO;
import mybatis.hr.vo.Department;
import mybatis.hr.vo.Employee;

public class TestDepartment {
	public static void main(String[] args) {
		DepartmentDAO dao = DepartmentDAO.getInstance();
		Department dept = dao.selectDepartmentById_JoinEmployee(300);
		System.out.println(dept);
		List<Employee> employees = dept.getEmployees();
		for (Employee e : employees) {
			System.out.println(e);
		}
		
//		Department dept = new Department(653, "653번부서", "서울");
//		int cnt = dao.insertDepartment(dept);
//		System.out.println("insert된 부서수 : " + cnt);
//		System.out.println("-------------------- 부서 ID로 부서 변경 ---------------------");
//		Department dept = new Department(653, "653번부서임", "대전");
//		int cnt = dao.updateDepartment(dept);
//		System.out.println("update된 부서수 : " + cnt);
//		System.out.println("-------------------- 부서 ID로 부서 삭제 ---------------------");
//		int cnt  = dao.deleteDepartmentById(653);
//		System.out.println("delete된 부서수 : " + cnt);
//		System.out.println("-------------------- 부서 Location으로 부서 삭제 ---------------------");
//		int cnt  = dao.deleteDepartmentByLocation("경기");
//		System.out.println("delete된 부서수 : " + cnt);
//		System.out.println("-------------------- 부서 ID로 부서 조회 ---------------------");
//		Map map  = dao.selectMemberByIdMap(653);
//		System.out.println(map);
//		System.out.println("-------------------- 전체 부서 조회 ---------------------");
//		List<Department> list = dao.selectDepartmentsList();
//		for (Department dept : list) {
//			System.out.println(dept);
//		}
//		System.out.println("-------------------- 전체 부서 조회 : Map ---------------------");
//		Map<Integer, Department> mapList = dao.selectDepartmentsList_Map();
//		Set<Entry<Integer, Department>> set = mapList.entrySet();
//		Iterator<Entry<Integer, Department>> itr = set.iterator();
//		
//		while (itr.hasNext()) {
//			Entry<Integer, Department> entry = itr.next();
//			System.out.println(entry.getKey() + " : " + entry.getValue());
//		}
//		System.out.println("-------------------- 직원 테이블 조회 ---------------------");
//		list = dao.selectRandom("employee");
//		for (Object obj : list) {
//			System.out.println(obj);
//		}
//
//		System.out.println("-------------------- 부서명으로 조회 ---------------------");
//		list = dao.selectDepartmentByName("기획부");
//		for (Object obj : list) {
//			System.out.println(obj);
//		}
//
//		System.out.println("-------------------- 지역명으로 조회 ---------------------");
//		list = dao.selectDepartmentByLocation("서울");
//		for (Object obj : list) {
//			System.out.println(obj);
//		}
	}
}
