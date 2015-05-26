package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MybatisMemberService;
import member.vo.Member;

import common.controller.Controller;
import common.vo.AttributeAndView;

public class LoginController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		Member member = MybatisMemberService.getInstance().getMemberById(id);
		
		if (member != null && member.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60 * 30);// 세션만료기한 : 30분
			session.setAttribute("login_info", id);
			
			return new AttributeAndView(true, "/MemberManagement/index.jsp");
			
		}else if (member == null) {
			return new AttributeAndView(false, "/controller?command=link&href=/WEB-INF/member/login_form.jsp",
					"failMessage", id + "는 없는 ID입니다. 확인 후 다시 로그인 하세요.");
			
		} else {
			return new AttributeAndView(false, "/controller?command=link&href=/WEB-INF/member/login_form.jsp",
					"failMessage", "패스워드가 틀렸습니다. 확인 후 다시 로그인 하세요.");
			
		}
	}

}
