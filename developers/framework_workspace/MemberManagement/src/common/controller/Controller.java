package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.vo.AttributeAndView;


//업무 처리 컨트롤러들의 Type을 묶어줄 interface
//업무를 처리할 메소드를 선언.
public interface Controller {
	public abstract AttributeAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
