package common.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;


public class DataUtilListener implements ServletContextListener {
	private static BasicDataSource dataSource;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();
		
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(context.getInitParameter("oracle_db_driver"));
		dataSource.setUrl(context.getInitParameter("oracle_db_url"));
		dataSource.setUsername(context.getInitParameter("oracle_db_username"));
		dataSource.setPassword(context.getInitParameter("oracle_db_password"));
		
		dataSource.setInitialSize(10);
		dataSource.setMaxIdle(3);
		dataSource.setMinIdle(3);
		dataSource.setMaxWait(2000);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			dataSource.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	
	public static void close(Connection conn) throws SQLException {
		if (conn != null) conn.close();
	}
	
	public static void close(Connection conn, Statement stmt) throws SQLException {
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rset) throws SQLException {
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	}
	
	public static void close(Statement stmt) throws SQLException {
		if (stmt != null) stmt.close();
	}
	
	public static void close(Statement stmt, ResultSet rset) throws SQLException {
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
	}
}
