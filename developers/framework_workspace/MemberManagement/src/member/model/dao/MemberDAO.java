package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import common.util.DataUtilListener;
import member.vo.Member;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public Member selectMemberById(Connection conn, String id) throws SQLException {
		final String sql = "select id, password, name, email, join_date "
				+ "from member "
				+ "where id=?";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Member member = null;
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rset = pstmt.executeQuery();
		
//		while (rset.next()) {
//			member = new Member(
//						rset.getString("id"),
//						rset.getString("password"),
//						rset.getString("name"),
//						rset.getString("email"),
//						new Date(rset.getDate("join_date").getTime())
//					);
//		}

		DataUtilListener.close(pstmt, rset);
		
		return member;
	}

	public void insertMember(Connection conn, Member member) throws SQLException {
		final String sql = "insert into member values(?,?,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPassword());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getEmail());
		
	    java.sql.Date sqlDate = new java.sql.Date(member.getJoinDate().getTime());
		pstmt.setDate(5, sqlDate);
		
		pstmt.executeUpdate();
		
		DataUtilListener.close(pstmt);
	}

	public ArrayList<Member> selectAllMember(Connection conn) throws SQLException {
		final String sql = "select id, password, name, email, join_date from member";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		pstmt = conn.prepareStatement(sql);
		
		rset = pstmt.executeQuery();
		
//		while (rset.next()) {
//			Member member = new Member(
//						rset.getString("id"),
//						rset.getString("password"),
//						rset.getString("name"),
//						rset.getString("email"),
//						new Date(rset.getDate("join_date").getTime())
//					);
//			memberList.add(member);
//		}

		DataUtilListener.close(pstmt, rset);
		
		return memberList;
	}

	public void updateMember(Connection conn, Member member) throws SQLException {
		final String sql = "update member set "
				+ "password=?, name=?, email=?, join_date=? "
				+ "where id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getPassword());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getEmail());
		
	    java.sql.Date sqlDate = new java.sql.Date(member.getJoinDate().getTime());
		pstmt.setDate(4, sqlDate);
		
		pstmt.setString(5, member.getId());
		
		pstmt.executeUpdate();
		
		DataUtilListener.close(pstmt);
	}

	public void deleteMemberById(Connection conn, String id) throws SQLException {
		final String sql = "delete from member "
				+ "where id=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		pstmt.executeUpdate();
		
		DataUtilListener.close(pstmt);
	}

}
