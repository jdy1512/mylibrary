package common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.JoinMemberController;
import member.controller.JoinSuccessController;
import member.controller.LoginController;
import member.controller.LoginMemberInfoController;
import member.controller.LogoutController;
import member.controller.MemberListController;
import member.controller.ModifyFormController;
import member.controller.ModifyMemberController;
import member.controller.RemoveMemberController;
import member.exception.ExpiredSessionException;

import common.controller.Controller;
import common.controller.LinkController;
import common.vo.AttributeAndView;

public class HandlerMapping {

	public static AttributeAndView getController(String command, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Controller controller = null;

		// 세션 검사 x
		if (command.equals("joinMember")) {// 회원가입
			controller = new JoinMemberController();

		} else if (command.equals("joinSuccess")) {// 가입성공 - 정보
			controller = new JoinSuccessController();

		} else if (command.equals("login")) {// 로그인
			controller = new LoginController();

		} else if (command.equals("logout")) {// 로그아웃
			controller = new LogoutController();

		} else if (command.equals("memberList")) {// 회원목록조회
			controller = new MemberListController();

		} else if (command.equals("link")) {// 링크처리
			controller = new LinkController();

		} else if (command.equals("modifyMember")) {// 회원정보수정
			controller = new ModifyMemberController();

		} else {
			// 세션 검사 o
			HttpSession session = request.getSession(false);
			if (session == null) {
				throw new ExpiredSessionException("세션이 만료되었습니다.");
			}
			
			if (command.equals("getMemberInfo")) {// 회원정보조회
				controller = new LoginMemberInfoController();

			} else if (command.equals("modifyForm")) {// 회원정보수정 폼
				controller = new ModifyFormController();

			} else if (command.equals("removeMember")) {// 회원정보조회
				controller = new RemoveMemberController();

			} 
		}

		return controller.handleRequest(request, response);
	}
}
