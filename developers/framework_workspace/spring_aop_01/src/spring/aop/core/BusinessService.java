package spring.aop.core;

public interface BusinessService {

	public void businessMethodBefore1();
	public void businessMethodBefore2(String name);
	
	public String businessMethodReturn();
	public void businessMethodThrow() throws Exception;
}
