package com.mycom.dao;

import com.mycom.vo.Member;

public interface MemberDAO {

	public abstract Member selectMemberById(String id);

	public abstract void insertMember(Member member);

}