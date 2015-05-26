package spring.mvc.param;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.validation.CustomerValidator;
import spring.mvc.vo.Customer;

@Controller
@RequestMapping("/modelAttr")
public class ModelAttributeHandleController {
	
	@RequestMapping("/register.do")
	public String register(@ModelAttribute("cvo") Customer customer) {
		System.out.println("등록 정보 : " + customer);
		return "register_result.jsp";
	}
	
	@RequestMapping("/register_valid.do")
	public String registerValidate(@ModelAttribute Customer customer, Errors errors) {
		// Customer가 가진 요천파라미터 값들 검증 - CustomerValidator를 사용
		CustomerValidator validator = new CustomerValidator();
		validator.validate(customer, errors);
		
		// Errors 조회 - hasErrors() : boolean
		if (errors.hasErrors()) {
			System.out.println("총 에러수 : " + errors.getErrorCount());
			return "register_valid_form.jsp";
		} else {
			return "register_result.jsp";
		}
	}
}
