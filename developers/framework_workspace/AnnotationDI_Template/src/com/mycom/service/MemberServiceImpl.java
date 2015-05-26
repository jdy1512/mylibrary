package com.mycom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycom.dao.MemberDAO;
import com.mycom.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	//@Autowired // Spring container에 등록된 MemberDAO Type의 bean객체를 아래 변수에 주입
	//@Qualifier("memberDAO")
	private MemberDAO memberDAO;
	
	@Autowired
	public MemberServiceImpl(@Qualifier("memberDAO") MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public Member getMemberById(String id){
		return memberDAO.selectMemberById(id);
	}
	@Override
	public void joinMember(Member member){
		memberDAO.insertMember(member);
	}
}
