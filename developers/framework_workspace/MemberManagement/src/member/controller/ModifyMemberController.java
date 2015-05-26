package member.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MybatisMemberService;
import member.vo.Member;

import common.controller.Controller;
import common.vo.AttributeAndView;

public class ModifyMemberController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Date date = new Date();
		
		MybatisMemberService.getInstance().modifyMember(new Member(id, password, name, email, new java.sql.Date(date.getTime())));
		
		return new AttributeAndView(true, "/MemberManagement/controller?command=getMemberInfo");
	}

}
