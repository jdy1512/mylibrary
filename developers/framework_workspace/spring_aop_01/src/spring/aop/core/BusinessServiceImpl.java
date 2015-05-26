package spring.aop.core;

import java.io.IOException;

public class BusinessServiceImpl implements BusinessService {

	@Override
	public void businessMethodBefore1() {
		System.out.println("핵심로직.methodBefore1()");
	}

	@Override
	public void businessMethodBefore2(String name) {
		System.out.println("핵심로직.methodBefore2()" + name + "을 받았습니다.");
	}

	@Override
	public String businessMethodReturn() {
		System.out.println("핵심로직.businessMethodReturn() 실행");
		return "리턴값-문자열";
	}

	@Override
	public void businessMethodThrow() throws Exception {
		System.out.println("핵심로직.businessMethodThrow() 실행");
		throw new IOException("IOException 발생");
	}

}
