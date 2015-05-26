package common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;



public class DatabaseUtil {
	
	private BasicDataSource bds;
	public DatabaseUtil(BasicDataSource bds){
		this.bds = bds;
	}
	
	
	
	
	public Connection getConnection() throws SQLException{
		return bds.getConnection();
	}
	public void close(Connection conn) throws SQLException{
		if(conn != null){
			conn.close();
		}
	}
	public void close(PreparedStatement pstmt)  throws SQLException{
		
		if(pstmt != null){
			pstmt.close();
		}
		
	}
	public void close(PreparedStatement pstmt, ResultSet rset)  throws SQLException{
		if(rset != null){
			rset.close();
		}
		if(pstmt != null){
			pstmt.close();
		}
	}
	
}
















