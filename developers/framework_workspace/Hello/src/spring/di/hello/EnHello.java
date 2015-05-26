package spring.di.hello;

public class EnHello implements Hello{

	@Override
	public String sayHello(String name) {
		return name + ", How are you";
	}

}
