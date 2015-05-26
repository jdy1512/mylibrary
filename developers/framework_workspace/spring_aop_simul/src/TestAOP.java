import aop.core.CoreService;
import aop.core.CoreServiceProxy;


public class TestAOP {

	public static void main(String[] args) {
		CoreService s = getBean();
		
		s.coreMethod1();
		System.out.println("----------------------------");
		s.coreMethod2();
	}
	
	// Container역할 - Proxy객체를 생성해서 리턴
	public static CoreService getBean() {
		return new CoreServiceProxy();
	}
}
