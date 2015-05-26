package com.mycom.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mycom.service.MemberService;
import com.mycom.vo.Member;


public class TestMember {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/mycom/config/spring.xml");
		MemberService service = (MemberService) ctx.getBean("memberService");
		Member m = service.getMemberById("id-aaa");
		System.out.println(m);
		
		
	}
}
