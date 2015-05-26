package com.mycom.model.service;

import java.util.List;

import com.mycom.vo.Member;

public interface MemberService {

	public Member getMemberById(String id);
	
	public List<Member> getMemberList();
}
