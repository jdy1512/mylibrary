package common.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DatabaseManager {
	private static DatabaseManager instance = new DatabaseManager();
	private SqlSessionFactory sessionFactory;

	private DatabaseManager() {
		InputStream is = null;

		try {
			is = Resources.getResourceAsStream("common/config/mybatis-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	public static DatabaseManager getInstance() {
		return instance;
	}

	public SqlSession getSession() {
		return sessionFactory.openSession();
	}
}
