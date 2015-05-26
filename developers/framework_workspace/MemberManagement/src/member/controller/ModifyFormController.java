package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.Controller;
import common.vo.AttributeAndView;

public class ModifyFormController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new AttributeAndView(false, "/WEB-INF/member/modify_form.jsp");
	}

}
