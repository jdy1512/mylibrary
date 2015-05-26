package spring.mvc.param;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class RequestParameterHandleController {

	/*
	 * Handler 메소드들 (Controller로직처리 메소드들)
	 */
	
//	@RequestMapping("/requestForm.do")
//	public String requestForm() {
//		// request_form.jsp로 이동하는 controller메소드
//		return "request_form.jsp";//WEB-INF/view
//	}
	
	// 요청파라미터를 String 변수로 받기.
	@RequestMapping("/login.do")
	public String login(@RequestParam(value="login_id", required=false, defaultValue="기본값") String id, String password, HttpSession session) {
		System.out.println("login.do처리 : " + id + " - " + password);
		session.setAttribute("loginInfo", id);
		return "request_result.jsp";
	}
	
	// age=xxx&tall=xxx&mailing=xxx
	@RequestMapping("/variusType.do")
	public String variousType(@RequestParam(required=false, defaultValue="-1") int age, double tall, boolean mailing) {
		if (age == -1) System.out.println("나이를 넣으세요");
		System.out.printf("나이 : %d, 키 : %.2f, 메일 수신 여부 : %s", age, tall, mailing ? "수신" : "미수신");
		
		return "request_result.jsp";
	}
	
	@RequestMapping("/manyParams.do")
	public String manyParams(String[]txt, Model model) {
		for (String s : txt) {
			System.out.println(s);
		}
		model.addAttribute("key", "value");
		model.addAttribute("key2", "value2");
		return "request_result.jsp";
	}
}
