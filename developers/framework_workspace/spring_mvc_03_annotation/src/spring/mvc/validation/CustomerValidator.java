package spring.mvc.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.mvc.vo.Customer;

/*
 *  1. Validator를 implements - 메소드를 overriding
 */
public class CustomerValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Customer.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer cust = (Customer) target;
		//id - not null, 글자수 6이상
		//pwd, 이름, 이메일 - not null
		//취미, 관심분야(여러개) - 1개이상 선택
		String id = cust.getId();
		if (id == null || id.trim().isEmpty()) {
			// 매개변수 : 1 - 검증실패한 property명, 2 - , 3 - , 4 - 기본 에러메세지
			errors.rejectValue("id", "required", null, "id를 넣으세요");
		}
		if (id == null || id.length() < 6) {
			errors.rejectValue("id", "minlength", new Object[]{6}, "id는 6글자 이상 넣으세요");
		}
		
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
	}

}
