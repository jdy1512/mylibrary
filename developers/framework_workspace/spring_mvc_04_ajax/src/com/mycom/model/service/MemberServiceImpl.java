package com.mycom.model.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Component;

import com.mycom.vo.Member;

@Component("service")
public class MemberServiceImpl implements MemberService{

	@Override
	public Member getMemberById(String id) {
		int num = (int)(Math.random()*5);
		return new Member(id, "김철수"+num, 20+num);
	}

	@Override
	public List<Member> getMemberList() {
		ArrayList<Member> list = new ArrayList<Member>();
		list.add(new Member("id-1", "김영수",22));
		list.add(new Member("id-2", "하영일",26));
		list.add(new Member("id-3", "최명수",30));
		list.add(new Member("id-4", "이순이",36));
		list.add(new Member("id-5", "오영이",29));
		
		return list;
	}

	
}
