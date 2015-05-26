package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.vo.AttributeAndView;


// 단순 링크 처리 Controller
public class LinkController implements Controller {

	@Override
	public AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new AttributeAndView(false, request.getParameter("href"));
	}

}
