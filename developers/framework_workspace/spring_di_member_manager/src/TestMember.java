import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import member.model.service.MemberService;


public class TestMember {

	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("member/config/member.xml");
		MemberService service = (MemberService)ctx.getBean("service");
		
		

		
		System.out.println(service.getMemberById("id-11"));

	}

}
