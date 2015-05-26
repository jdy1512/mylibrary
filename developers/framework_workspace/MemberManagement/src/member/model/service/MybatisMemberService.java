package member.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.exception.DuplicateIdException;
import member.model.dao.MybatisMemberDAO;
import member.vo.Member;

import org.apache.ibatis.session.SqlSession;

import common.util.DatabaseManager;

public class MybatisMemberService {
	private static MybatisMemberService instance = new MybatisMemberService();
	private static MybatisMemberDAO memberDAO;
	
	public static MybatisMemberService getInstance() {
		if (memberDAO == null) {
			memberDAO = MybatisMemberDAO.getInstance();
		}
		return instance;
	}
	
	public void joinMember(Member member) throws SQLException, DuplicateIdException {
		SqlSession session = DatabaseManager.getInstance().getSession();
		
		try {
			
			if (memberDAO.selectMemberById(session, member.getId()) != null) {
				throw new DuplicateIdException("이미 존재하는 ID입니다.");
			}
			memberDAO.insertMember(session, member);
			session.commit();
		} catch (SQLException sqle) {
			throw sqle;
		} finally {
			session.close();
		}
	}
	
	public List<Member> getMemberList() throws SQLException {
		SqlSession session = DatabaseManager.getInstance().getSession();
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			memberList = memberDAO.selectAllMember(session);
		} finally {
			session.close();
		}
		return memberList;
	}
	
	public Member getMemberById(String id) throws SQLException {
		SqlSession session = DatabaseManager.getInstance().getSession();
		Member member = null;
		
		try {
			member = memberDAO.selectMemberById(session, id);
			System.out.println(member);
		} finally {
			session.close();
		}
		return member;
	}
	
	public void modifyMember(Member member) throws SQLException {
		SqlSession session = DatabaseManager.getInstance().getSession();
		
		try {
			memberDAO.updateMember(session, member);
			session.commit();
		} catch (SQLException sqle) {
			throw sqle;
		} finally {
			session.close();
		}
	}
	
	public void removeMemberById(String id) throws SQLException {
		SqlSession session = DatabaseManager.getInstance().getSession();
		
		try {
			memberDAO.deleteMemberById(session, id);
			session.commit();
		} catch (SQLException sqle) {
			throw sqle;
		} finally {
			session.close();
		}
	}

}
