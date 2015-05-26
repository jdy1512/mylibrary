import member.model.service.MemberService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMember {

//	@Autowired
//	private MemberService service;
	
	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("member/config/member-impl.xml");
		MemberService service = (MemberService)ctx.getBean("service");
		System.out.println( service.getMemberList());
		
//		TestMember tm = new TestMember();
//		System.out.println( tm.service.getMemberList());

	}

}
