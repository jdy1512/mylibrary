package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import member.exception.DuplicatedIdException;
import member.model.dao.MemberDAO;
import member.vo.Member;

import common.util.DatabaseUtil;
import common.util.PagingBean;


/**
 * 회원 관리 Business Logic을 처리하는 Business Service 클래스
 * @author kgmyh
 *
 */
public class MemberService {
	
	private MemberDAO dao;
	public DatabaseUtil dbUtil;
	public MemberService(MemberDAO dao, DatabaseUtil dbUtil){
		this.dao = dao;
		this.dbUtil = dbUtil;
	}
	/**
	 * 가입 처리 메소드
	 * @param member 가입 정보
	 * @throws SQLException
	 * @throws DuplicatedIdException 중복된 아이디일 경우 발생
	 */
	public void joinMember(Member member) throws SQLException,
																			DuplicatedIdException{
		Connection conn = dbUtil.getConnection();
		//1. 등록된 ID가 있는 지 체크
		//    - 이미 등록된 ID라면 DuplicatedIdException를 발생 시킨다.
		if(dao.selectMemberById(conn, member.getId())!=null){
			throw new DuplicatedIdException(member.getId()+"는 이미 등록된 아이디입니다. ID를 변경하세요");
		}
		//2. 디비에 회원정보 등록 처리
		dao.insertMember(conn, member);
		
		//3. connection close
		dbUtil.close(conn);
	}
	/**
	 * 전체 회원 목록 조회 처리
	 * @return ArrayList
	 * @throws SQLException
	 */
	public ArrayList<Member> getMemberList() throws SQLException{
		Connection conn = dbUtil.getConnection();
		ArrayList<Member> list = dao.selectAllMember(conn);
		dbUtil.close(conn);
		return list;
	}
	/**
	 * 전체 회원 목록 조회 처리 - Paging 처리
	 * @param page : 조회할 page 번호
	 * @return ArrayList
	 * @throws SQLException
	 */
	public Map getMemberListPaging(int page) throws SQLException{
		Connection conn = dbUtil.getConnection();
		//목록에 뿌려줄 List<Member> 조회
		ArrayList<Member> list = dao.selectAllMemberPaging(conn, page);
		//PagingBean 생성
		int totalContent = dao.selectTotalMemberCount(conn);
		PagingBean pagingBean = new PagingBean(totalContent, page);
		//두개의 값(ArrayList, PagingBean)을 Map에 넣어 return
		HashMap map = new HashMap();
		map.put("member_list", list);
		map.put("pagingBean", pagingBean);
		dbUtil.close(conn);
		return map;
	}
	/**
	 * ID로 회원 조회 메소드
	 * @param id : 조회할 회원 ID
	 * @return
	 * @throws SQLException
	 */
	public Member getMemberById(String id) throws SQLException{
		Connection conn = dbUtil.getConnection();
		Member member = dao.selectMemberById(conn, id);
		dbUtil.close(conn);
		return member;
	}
	/**
	 * 회원 정보 수정 처리 메소드
	 * @param member 수정할 회원 전보
	 * @throws SQLException
	 */
	public void modifyMember(Member member) throws SQLException{
		Connection conn = dbUtil.getConnection();
		dao.updateMember(conn, member);
		dbUtil.close(conn);
	}
	/**
	 * 회원 탈퇴 메소드
	 * @param id 탈퇴할 회원 ID
	 * @throws SQLException
	 */
	public void removeMemberById(String id) throws SQLException {
		Connection conn = dbUtil.getConnection();
		dao.deleteMemberById(conn, id);
		dbUtil.close(conn);
	}
	
}

















