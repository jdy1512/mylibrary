package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MybatisMemberService;
import member.vo.Member;

import common.controller.Controller;
import common.vo.AttributeAndView;

public class MemberListController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Member> memberList = MybatisMemberService.getInstance().getMemberList();
		
		return new AttributeAndView(false, "/WEB-INF/member/member_list.jsp", "memberList", memberList);
	}

}
