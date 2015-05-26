package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.vo.Member;
import common.util.DatabaseUtil;

public class MemberDAO {

	private DatabaseUtil dbUtil;
	public MemberDAO(DatabaseUtil dbUtil){
		this.dbUtil = dbUtil;
	}
	
	/**
	 * id로 회원 정보를 조회하여 return하는 메소드
	 * @param id 조회할 회원 ID
	 * @return 
	 * @throws SQLException
	 */
	public Member selectMemberById(Connection conn, String id) throws SQLException{
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "select id, password, name, email, to_char(to_date(join_date, 'yyyymmdd'), 'yyyy-mm-dd') join_date from member where id=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			if(rset.next()){
				member = new Member(	rset.getString(1),
												 	rset.getString(2),
												 	rset.getString(3),
												 	rset.getString(4),
												 	rset.getString(5));
			}
		}finally{
			dbUtil.close(pstmt, rset);
		}
		return member;
	}
	/**
	 * 회원 정보를 DB에 insert하는 메소드
	 * @param member 등록할 회원 정보
	 * @throws SQLException
	 */
	public int insertMember(Connection conn, Member member) throws SQLException{
		PreparedStatement pstmt = null;
		String sql = "insert into member (id, password, name, email, join_date) values (?,?,?,?,to_char(sysdate, 'yyyymmdd'))";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			return pstmt.executeUpdate();
		}finally{
			dbUtil.close(pstmt);
		}
	}
	/**
	 * Member 테이블의 전체 회원정보 조회 처리
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Member> selectAllMember(Connection conn) throws SQLException{
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select id, password, name, email, to_char(to_date(join_date, 'yyyymmdd'), 'yyyy-mm-dd') join_date from member order by join_date, id ";
		try{
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()){
				list.add(new Member(	rset.getString(1),
											   	rset.getString(2),
												rset.getString(3),
												rset.getString(4),
												rset.getString(5)));
			}
		}finally{
			dbUtil.close(pstmt, rset);
		}
		return list;
	}
	
	/**
	 * 회원 정보 수정 메소드
	 * 매개변수로 받은 Member객체의 id 회원의 나머지 정보를 변경한다. 단 ID와 가입일자는 변경 안한다.
	 * @param member
	 * @throws SQLException
	 */
	public int updateMember(Connection conn, Member member) throws SQLException{
		PreparedStatement pstmt = null;
		String sql = "update member set password=?, name=?, email=? where id=?";
		try{
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getPassword());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getId());
			return pstmt.executeUpdate();
		}finally{
			dbUtil.close(pstmt);
		}
	}
	/**
	 * 매개 변수로 받은 ID의 회원을 삭제하는 메소드
	 * @param id
	 * @throws SQLException
	 */
	public int deleteMemberById(Connection conn, String id) throws SQLException{
		PreparedStatement pstmt = null;
		String sql = "delete from member where id=?";
		try{
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		}finally{
			dbUtil.close(pstmt);
		}
	}
	public int selectTotalMemberCount(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "select count(id) from member";
		int cnt = 0;
		try{
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				cnt = rset.getInt(1);
			}
		}finally{
			dbUtil.close(pstmt, rset);
		}
		return cnt;
	}
	
	/**
	 * Member 테이블의 전체 회원정보 조회 처리
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Member> selectAllMemberPaging(Connection conn, int page) throws SQLException{
		ArrayList<Member> list = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select id, password, name, email, join_date from("
				+ "select ceil(rownum/10) page, id, password, name, email, join_date from ("
				+ "select id, password, name, email, to_char(to_date(join_date, 'yyyymmdd'), 'yyyy-mm-dd') join_date from member order by join_date, id ))"
				+ " where page=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			rset = pstmt.executeQuery();
			while(rset.next()){
				list.add(new Member(	rset.getString(1),
											   	rset.getString(2),
												rset.getString(3),
												rset.getString(4),
												rset.getString(5)));
			}
		}finally{
			dbUtil.close(pstmt, rset);
		}
		return list;
	}
}











