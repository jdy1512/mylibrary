package com.mycom.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.member.exception.DuplicatedIdException;
import com.mycom.member.model.service.MemberService;
import com.mycom.member.vo.Member;


public class TestMember {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/mycom/common/config/spring-member.xml");
		
		MemberService service = (MemberService) ctx.getBean("service");
		
		// Transaction테스트
		Member m1 = new Member("id-5", "1234", "홍길동", "hong@gmail.com");
		Member m2 = new Member("id-6", "12345", "김길동", "kim@naver.com");
		
		try {
			service.testTransaction(m1, m2);
		} catch (Exception e) {
		}
		
		List<Member> list = service.getMemberList();
		
		for (Member m : list) {
			System.out.println(m);
		}
	}
}
