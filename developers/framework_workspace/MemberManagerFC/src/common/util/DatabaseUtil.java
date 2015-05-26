package common.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;




public class DatabaseUtil {
private SqlSessionFactory sessionFactory;
	
	private static DatabaseUtil instance = new DatabaseUtil();
	
	private DatabaseUtil() {
			InputStream is = null;
			try{
				is=Resources.getResourceAsStream("memberManager-config.xml");
			}catch(IOException e){
				e.printStackTrace();
			}
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			sessionFactory = builder.build(is);
	}
	
	public static DatabaseUtil getInstance() {
		return instance;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		return sessionFactory;
	}
	
}
















