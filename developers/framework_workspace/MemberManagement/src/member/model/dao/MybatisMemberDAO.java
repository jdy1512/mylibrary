package member.model.dao;

import java.sql.SQLException;
import java.util.List;

import member.vo.Member;

import org.apache.ibatis.session.SqlSession;

public class MybatisMemberDAO {
	private static MybatisMemberDAO instance = new MybatisMemberDAO();
	private String namespace = "member.";

	public static MybatisMemberDAO getInstance() {
		return instance;
	}

	public Member selectMemberById(SqlSession session, String id) throws SQLException {
		return session.selectOne(namespace + "selectMemberById", id);
	}

	public int insertMember(SqlSession session, Member member) throws SQLException {
		return session.insert(namespace + "insertMember", member);
	}

	public List<Member> selectAllMember(SqlSession session) throws SQLException {
		return session.selectList(namespace + "selectAllMember");
	}

	public int updateMember(SqlSession session, Member member) throws SQLException {
		return session.update(namespace + "updateMember", member);
	}

	public int deleteMemberById(SqlSession session, String id) throws SQLException {
		return session.delete(namespace + "deleteMemberById", id);
	}

}
