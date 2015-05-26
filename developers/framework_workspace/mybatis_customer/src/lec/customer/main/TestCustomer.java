package lec.customer.main;

import java.util.List;

import lec.customer.dao.CustomerDAO;
import lec.customer.vo.Customer;

public class TestCustomer {

	public static void main(String[] args) {
		CustomerDAO dao = CustomerDAO.getInstance();
		
//		dao.insertCustomer(new Customer("id-2", "1234", "홍길동", "test@google.gmail", "010-1234-5678", 0));
		
//		dao.updateCustomer(new Customer("id-1", "1234", "김길동", "test@google.gmail", "010-1234-5678", 10000));

//		dao.deleteCustomerById("id-1");
		
//		Customer customer = dao.selectCustomerById("id-1");
//		System.out.println(customer);

//		Customer customer = dao.selectCustomerByName("홍길동");
//		System.out.println(customer);

//		Customer customer = dao.selectCustomerByEmail("test@google.gmail");
//		System.out.println(customer);

		List<Customer> customerList = dao.selectCustomerByMileageRange(0, 100000);
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
	}
}
