package spring.di.vo;

public class Address {
	private String zipcode;
	private String address;

	public Address() {
	}

	public Address(String zipcode, String address) {
		this.zipcode = zipcode;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [zipcode=" + zipcode + ", address=" + address + "]";
	}

}
