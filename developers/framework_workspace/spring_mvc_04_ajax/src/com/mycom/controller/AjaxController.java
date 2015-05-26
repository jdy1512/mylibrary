package com.mycom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.model.service.MemberService;
import com.mycom.vo.Member;


@Controller
public class AjaxController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/ajax/findById.do")
	@ResponseBody // return되는 값을 http로 응답
	public String findMemberById(@RequestParam String id) {
		// B.L
		Member member = service.getMemberById(id);
		
		// 응답
		// format() -> pringf() 와 동일한 형식인데 출력이 아니라 문자열 만들때 사용
		String result = String.format("ID : %s<br/>이름 : %s<br/>나이 : %d",
				member.getId(), member.getName(), member.getAge());
		return result;
	}
	
	@RequestMapping("/ajax/findById_JSON")
	@ResponseBody // return되는 값을 http로 응답
	public Member findMemberById_JSON(@RequestParam String id) {
		// B.L
		return service.getMemberById(id);
	}
	
	
	/*
	 *  @ResponseBody을 이용해 JSON 문자열 응답처리 하기.
	 *   - MappingJackson2HttpMessageConverter : 리턴값을 JSON 문자열로 변환해 응답body에 넣는 컨버터
	 *   <mvc:annotation-driven/> 설정시 자동으로 등록
	 *    - Jackson Json api 모듈이 classpath에 있어야 한다.
	 */
	
	
	
	@RequestMapping("/ajax/memberList.do")
	@ResponseBody
	public List<Member> memberList() {
		return service.getMemberList();
	}
}
