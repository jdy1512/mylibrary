package spring.di.hello;

public class KorHello implements Hello{

	@Override
	public String sayHello(String name) {
		return name + "님 안녕하세요";
	}

}
