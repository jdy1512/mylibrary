package member.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MybatisMemberService;
import member.vo.Member;

import common.controller.Controller;
import common.vo.AttributeAndView;

public class JoinSuccessController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		
		Member member = MybatisMemberService.getInstance().getMemberById(id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", member.getId());
		map.put("password", member.getPassword());
		map.put("name", member.getName());
		map.put("email", member.getEmail());
		map.put("joinDate", new SimpleDateFormat("yyyy-MM-dd").format(member.getJoinDate()));
		
		return new AttributeAndView(false, "/WEB-INF/member/join_success.jsp", map);
	}

}
