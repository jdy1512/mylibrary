package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.Controller;
import common.vo.AttributeAndView;

public class LogoutController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		
		return new AttributeAndView(true, "/MemberManagement/controller?command=link&href=/WEB-INF/member/login_form.jsp");
	}

}
