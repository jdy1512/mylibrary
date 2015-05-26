package mybatis.hr.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseManager {
	private SqlSessionFactory sessionFactory;
	private static DatabaseManager instance = new DatabaseManager();
	
	public static DatabaseManager getInstance() {
		return instance;
	}
	
	private DatabaseManager() {
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-db-config.xml");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sessionFactory;
	}
}
