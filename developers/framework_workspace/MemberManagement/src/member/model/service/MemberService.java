package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import member.exception.DuplicateIdException;
import member.model.dao.MemberDAO;
import member.vo.Member;

import common.util.DataUtilListener;

public class MemberService {
	private static MemberService instance = new MemberService();
	private static MemberDAO memberDAO;
	
	public static MemberService getInstance() {
		if (memberDAO == null) {
			memberDAO = MemberDAO.getInstance();
		}
		return instance;
	}
	
	public void joinMember(Member member) throws SQLException, DuplicateIdException {
		Connection conn = null;
		
		try {
			conn = DataUtilListener.getConnection();
			conn.setAutoCommit(false);
			
			if (memberDAO.selectMemberById(conn, member.getId()) != null) {
				throw new DuplicateIdException("이미 존재하는 ID입니다.");
			}
			memberDAO.insertMember(conn, member);
			
		} catch (SQLException sqle) {
			conn.rollback();
			throw sqle;
			
		} finally {
			conn.setAutoCommit(true);
			DataUtilListener.close(conn);
		}
	}
	
	public ArrayList<Member> getMemberList() throws SQLException {
		Connection conn = null;
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		try {
			conn = DataUtilListener.getConnection();
			memberList = memberDAO.selectAllMember(conn);
			
		} finally {
			DataUtilListener.close(conn);
		}
		
		return memberList;
	}
	
	public Member getMemberById(String id) throws SQLException {
		Member member = null;
		Connection conn = null;
		
		try {
			conn = DataUtilListener.getConnection();
			member = memberDAO.selectMemberById(conn, id);
			
		} finally {
			DataUtilListener.close(conn);
		}

		return member;
	}
	
	public void modifyMember(Member member) throws SQLException {
		Connection conn = null;
		
		try {
			conn = DataUtilListener.getConnection();
			conn.setAutoCommit(false);
			
			memberDAO.updateMember(conn, member);
			
		} catch (SQLException sqle) {
			conn.rollback();
			throw sqle;
			
		} finally {
			conn.setAutoCommit(true);
			DataUtilListener.close(conn);
		}
	}
	
	public void removeMemberById(String id) throws SQLException {
		Connection conn = null;
		
		try {
			conn = DataUtilListener.getConnection();
			conn.setAutoCommit(false);
			
			memberDAO.deleteMemberById(conn, id);
			
		} catch (SQLException sqle) {
			conn.rollback();
			throw sqle;
			
		} finally {
			conn.setAutoCommit(true);
			DataUtilListener.close(conn);
		}
	}

}
