package spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/test1")
	public String test1() {
		System.out.println("TestController.test1() 실행");
		return "response.jsp";
	}
}
