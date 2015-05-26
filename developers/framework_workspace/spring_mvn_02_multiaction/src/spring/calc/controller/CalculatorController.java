package spring.calc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import spring.calc.vo.Operand;

public class CalculatorController extends MultiActionController {
	
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "index"; // View Name 리턴
	}
	
	public String calcForm(HttpServletRequest request, HttpServletResponse response) {
		return "calculator_form"; // View Name 리턴
	}
	
	public ModelAndView plus(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv;
		
		// 1. 요청파라미터 조회
		int op1 = Integer.parseInt(request.getParameter("op1"));
		int op2 = Integer.parseInt(request.getParameter("op2"));
		
		// 2. Business Logic 처리
		int result = op1 + op2; // Business Service 호출
		
		// 3. 응답
		mv = new ModelAndView("result", "result", result);
		return mv;
	}
	
	public ModelAndView minus(HttpServletRequest request, HttpServletResponse response, Operand op) {
		ModelAndView mv;
		
		// 2. Business Logic 처리
		int result = op.getOp1() - op.getOp2(); // Business Service 호출
		
		// 3. 응답
		mv = new ModelAndView("result", "result", result);
		return mv;
	}
}
