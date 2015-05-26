package member.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import member.vo.Member;


public interface MemberDAO {
	public abstract Member selectMemberById(Connection conn, String id) throws SQLException;
	
	public abstract int insertMember(Connection conn, Member member) throws SQLException;
	
	public abstract ArrayList<Member> selectAllMember(Connection conn) throws SQLException;
	
	public abstract int updateMember(Connection conn, Member member) throws SQLException;
	
	public abstract int deleteMemberById(Connection conn, String id) throws SQLException;
	
	public abstract int selectTotalMemberCount(Connection conn) throws SQLException;
	
	public abstract ArrayList<Member> selectAllMemberPaging(Connection conn, int page) throws SQLException;
}











