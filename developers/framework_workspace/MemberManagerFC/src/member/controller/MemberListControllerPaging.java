package member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.vo.Member;
import common.controller.AttributeAndView;
import common.controller.Controller;
import common.util.PagingBean;

public class MemberListControllerPaging implements Controller {

	 
	@Override
	public AttributeAndView handle(HttpServletRequest request, HttpServletResponse response){
		AttributeAndView av = null;
		try {
			MemberService ms = MemberService.getInstance();
			int pageNo=1;
			try{
				System.out.println(request.getParameter("pageNo"));
				pageNo =Integer.parseInt(request.getParameter("pageNo"));
			System.out.println(pageNo);
			
			}catch(Exception e){
				
				System.out.println("error");
			}
			Map map = (Map)ms.getMemberListPaging(pageNo);
		
			
			av = new AttributeAndView("/WEB-INF/view/member/member_list_paging.jsp", false, map);
		} catch (Exception e) {
			e.printStackTrace();
			av = new AttributeAndView("/WEB-INF/view/error.jsp", false, "error_message", e.getMessage());
		}
		return av;
	}

}

