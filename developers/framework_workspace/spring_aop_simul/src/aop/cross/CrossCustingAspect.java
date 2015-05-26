package aop.cross;

public class CrossCustingAspect {

	public void commonMethod() {
		System.out.println("공통서비스 로직을 실행합니다."); // TX, 보안, 로그 ...
	}
}
