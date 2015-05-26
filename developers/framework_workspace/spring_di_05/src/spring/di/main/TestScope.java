package spring.di.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/di/config/spring.xml");
		System.out.println("--------------- main ----------------");
		
		Object o1 = ctx.getBean("testVO");
		Object o2 = ctx.getBean("testVO");
		Object o3 = ctx.getBean("testVO");
		
		System.out.println(o1 == o2 && o2 == o3);
	}
}
