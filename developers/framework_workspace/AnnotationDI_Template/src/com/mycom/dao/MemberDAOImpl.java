package com.mycom.dao;

import org.springframework.stereotype.Repository;

import com.mycom.vo.Member;

@Repository("memberDAO") // name=memberDAOImpl
public class MemberDAOImpl implements MemberDAO {

	@Override
	public Member selectMemberById(String id){
		int k = (int)(Math.random()*9)+1;
		return new Member(id, "이순신"+k, 20+k);
	}
	@Override
	public void insertMember(Member member){
		System.out.println("회원 등록 : "+member);
	}
}
