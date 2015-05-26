package sample;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class Test01 {
	public static void main(String[] args) throws IOException {
		List<Department> list = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config2.xml")).openSession()
				.selectList("department.selectDepartmentsList");
		for (Department dept : list) {
			System.out.println(dept);
		}
	}
}
